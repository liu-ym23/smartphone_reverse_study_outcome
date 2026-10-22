package com.ss.android.socialbase.downloader.downloader;

import android.text.TextUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.exception.DownloadTTNetException;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.HttpHeader;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
public class NetworkFailoverStrategy {
    private static final String FALLBACK_ERROR_IP = "0.0.0.0";
    private static final String TAG = "NetworkFailoverStrategy";
    private static final int TTNET_HTTP_PROTO_TYPE_HTTP1 = 1;
    private static final int TTNET_HTTP_PROTO_TYPE_HTTP2 = 2;
    private static final int TTNET_HTTP_PROTO_TYPE_QUIC = 3;
    private static final String TTNET_ISOLATION_HEADER_KEY = "x-ttnet-isolation-info";
    private static final String TTNET_ISOLATION_HEADER_VALUE = "https://dl";
    private int mBackHostCountLimit;
    private Set<Integer> mBackHostErrorCodeSet;
    private List<String> mBackHostList;
    private List<Long> mConnectTimeoutList;
    private String mDownloadHost;
    private int mDownloadId;
    private List<FailoverStrategy> mFailoverStrategyList;
    private List<Long> mIoTimeoutList;
    private int mIpChangeCountLimit;
    private Set<Integer> mIpChangeErrorCodeSet;
    private int mIsolationCount;
    private Set<Integer> mIsolationErrorCodeSet;
    private int mIsolationHttpProtoType;
    private Set<Integer> mTimeoutErrorCodeSet;

    public class BackHostStrategyImpl implements FailoverStrategy {
        private boolean mBackHostEnable;
        private int mCurrentBackHostCount;
        private boolean mHandleCurrentBackHostHeader;
        final /* synthetic */ NetworkFailoverStrategy this$0;

        @Override // com.ss.android.socialbase.downloader.downloader.NetworkFailoverStrategy.FailoverStrategy
        public boolean isFailoverOnly() {
            return true;
        }

        public BackHostStrategyImpl(NetworkFailoverStrategy r100) {
            this.this$0 = r100;
            this.mBackHostEnable = false;
            this.mHandleCurrentBackHostHeader = false;
            this.mCurrentBackHostCount = -1;
            if (NetworkFailoverStrategy.access$600(r100) > 0) goto L5;
            return;
        L5:
            if (NetworkFailoverStrategy.access$700(r100).isEmpty() == true) goto L9;
            this.mBackHostEnable = true;
            return;
        }

        private boolean handleBackHostError(BaseException r100) {
            if (this.mBackHostEnable == true) goto L5;
        L26:
            return false;
        L5:
            if (this.mCurrentBackHostCount >= NetworkFailoverStrategy.access$600(this.this$0)) goto L26;
            if (NetworkFailoverStrategy.access$800(this.this$0).isEmpty() == false) goto L10;
        L13:
            boolean r101 = true;
        L15:
            if (r101 == false) goto L24;
            int r102 = this.mCurrentBackHostCount + 1;
            this.mCurrentBackHostCount = r102;
            if (r102 == NetworkFailoverStrategy.access$600(this.this$0)) goto L19;
            return true;
        L19:
            if (Logger.debug() == false) goto L21;
            Logger.taskDebug(NetworkFailoverStrategy.TAG, NetworkFailoverStrategy.access$200(this.this$0), "handleBackHostError", "BackHostCountLimit" + NetworkFailoverStrategy.access$600(this.this$0) + " currentBackHostCount:" + this.mCurrentBackHostCount + " errorCode:" + r100.getErrorCode());
        L21:
            return false;
        L24:
            if (Logger.debug() == false) goto L26;
            Logger.taskDebug(NetworkFailoverStrategy.TAG, NetworkFailoverStrategy.access$200(this.this$0), "handleBackHostError", "IsMatch" + r101 + " BackHostCountLimit:" + NetworkFailoverStrategy.access$600(this.this$0) + " errorCode:" + r100.getErrorCode());
            goto L26
        L10:
            if (NetworkFailoverStrategy.access$800(this.this$0).contains(Integer.valueOf(r100.getErrorCode())) == true) goto L13;
            r101 = false;
            goto L15
        }

        private void handleBackHostHeader(List<HttpHeader> r100) {
            if (this.mBackHostEnable == true) goto L5;
            return;
        L5:
            if (this.mHandleCurrentBackHostHeader == false) goto L17;
            int r101 = this.mCurrentBackHostCount;
            if (r101 >= 0) goto L9;
            return;
        L9:
            if (r101 >= NetworkFailoverStrategy.access$600(this.this$0)) goto L19;
            this.mHandleCurrentBackHostHeader = false;
            String r102 = (String) ListProtector.get(NetworkFailoverStrategy.access$700(this.this$0), this.mCurrentBackHostCount % NetworkFailoverStrategy.access$700(this.this$0).size());
            if (Logger.debug() == false) goto L14;
            Logger.taskDebug(NetworkFailoverStrategy.TAG, NetworkFailoverStrategy.access$200(this.this$0), "handleBackHostHeader", "Add BackHost Header: " + r102);
        L14:
            r100.add(new HttpHeader(DownloadConstants.EXTRA_TTNET_BACK_HOST, r102));
            return;
        L19:
            return;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.NetworkFailoverStrategy.FailoverStrategy
        public boolean handleError(BaseException r100) {
            boolean r101 = handleBackHostError(r100);
            this.mHandleCurrentBackHostHeader = r101;
            return r101;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.NetworkFailoverStrategy.FailoverStrategy
        public void handleHeader(List<HttpHeader> r100) {
            handleBackHostHeader(r100);
        }
    }

    public class DefaultIpChangeStrategyImpl implements FailoverStrategy {
        private int mCurrentIpChangeCount;
        private boolean mHandleCurrentIpChangeHeader;
        private boolean mIpChangeEnable;
        private Set<String> mIpChangeErrorIps;
        final /* synthetic */ NetworkFailoverStrategy this$0;

        @Override // com.ss.android.socialbase.downloader.downloader.NetworkFailoverStrategy.FailoverStrategy
        public boolean isFailoverOnly() {
            return true;
        }

        public DefaultIpChangeStrategyImpl(NetworkFailoverStrategy r100) {
            this.this$0 = r100;
            this.mIpChangeEnable = false;
            this.mHandleCurrentIpChangeHeader = false;
            this.mCurrentIpChangeCount = -1;
            this.mIpChangeErrorIps = new HashSet();
            if (NetworkFailoverStrategy.access$000(r100) > 0) goto L5;
            return;
        L5:
            if (NetworkFailoverStrategy.access$100(r100).isEmpty() == true) goto L9;
            this.mIpChangeEnable = true;
            return;
        }

        private boolean handleIpChangeError(BaseException r100) {
            if (this.mIpChangeEnable == true) goto L5;
        L29:
            return false;
        L5:
            if ((r100 instanceof DownloadTTNetException) == false) goto L29;
            if (this.mCurrentIpChangeCount >= NetworkFailoverStrategy.access$000(this.this$0)) goto L29;
            if (NetworkFailoverStrategy.access$100(this.this$0).contains(Integer.valueOf(r100.getErrorCode())) == true) goto L12;
            return false;
        L12:
            String r101 = ((DownloadTTNetException) r100).getRemoteIp();
            if (this.mCurrentIpChangeCount >= NetworkFailoverStrategy.access$000(this.this$0)) goto L27;
            int r102 = this.mCurrentIpChangeCount + 1;
            this.mCurrentIpChangeCount = r102;
            if (r102 != NetworkFailoverStrategy.access$000(this.this$0)) goto L21;
            if (Logger.debug() == false) goto L19;
            Logger.taskDebug(NetworkFailoverStrategy.TAG, NetworkFailoverStrategy.access$200(this.this$0), "handleIpChangeError", "CurrentIpChangeCount:" + this.mCurrentIpChangeCount + " mIpChangeCountLimit:" + NetworkFailoverStrategy.access$000(this.this$0));
        L19:
            return false;
        L21:
            if (TextUtils.isEmpty(r101) == true) goto L24;
            this.mIpChangeErrorIps.add(r101);
            return true;
        L24:
            this.mIpChangeErrorIps.add(NetworkFailoverStrategy.FALLBACK_ERROR_IP);
            return true;
        L27:
            if (Logger.debug() == false) goto L29;
            Logger.taskDebug(NetworkFailoverStrategy.TAG, NetworkFailoverStrategy.access$200(this.this$0), "handleIpChangeError", " RemoteIp:" + r101 + " currentIpChangeCount:" + this.mCurrentIpChangeCount + " errorCode:" + r100.getErrorCode() + " mIpChangeErrorIps:" + this.mIpChangeErrorIps.toString());
            goto L29
        }

        private void handleIpChangeHeader(List<HttpHeader> r100) {
            if (this.mIpChangeEnable == true) goto L5;
            return;
        L5:
            if (this.mHandleCurrentIpChangeHeader == false) goto L22;
            int r101 = this.mCurrentIpChangeCount;
            if (r101 >= 0) goto L9;
            return;
        L9:
            if (r101 >= NetworkFailoverStrategy.access$000(this.this$0)) goto L24;
            this.mHandleCurrentIpChangeHeader = false;
            StringBuilder r102 = new StringBuilder();
            Iterator<String> r103 = this.mIpChangeErrorIps.iterator();
        L13:
            if (r103.hasNext() == false) goto L16;
            r102.append(r103.next());
            r102.append(",");
            goto L13
        L16:
            if (Logger.debug() == false) goto L18;
            Logger.taskDebug(NetworkFailoverStrategy.TAG, NetworkFailoverStrategy.access$200(this.this$0), "handleIpChangeHeader", "Add extra_ttnet_change_ip:" + r102.toString());
        L18:
            r100.add(new HttpHeader(DownloadConstants.EXTRA_TTNET_CHANGE_IP, r102.toString()));
            return;
        L24:
            return;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.NetworkFailoverStrategy.FailoverStrategy
        public boolean handleError(BaseException r100) {
            boolean r101 = handleIpChangeError(r100);
            this.mHandleCurrentIpChangeHeader = r101;
            return r101;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.NetworkFailoverStrategy.FailoverStrategy
        public void handleHeader(List<HttpHeader> r100) {
            handleIpChangeHeader(r100);
        }
    }

    public interface FailoverStrategy {
        boolean handleError(BaseException r100);

        void handleHeader(List<HttpHeader> r100);

        boolean isFailoverOnly();
    }

    public class IsolationIpChangeStrategyImpl extends DefaultIpChangeStrategyImpl {
        private boolean mHandleCurrentIsolationHeader;
        private boolean mIsolationEnable;
        private int mIsolationIndex;
        final /* synthetic */ NetworkFailoverStrategy this$0;

        public IsolationIpChangeStrategyImpl(NetworkFailoverStrategy r100) {
            this.this$0 = r100;
            super(r100);
            this.mIsolationEnable = false;
            this.mHandleCurrentIsolationHeader = false;
            this.mIsolationIndex = -1;
            if (NetworkFailoverStrategy.access$300(r100) > 0) goto L5;
            return;
        L5:
            if (NetworkFailoverStrategy.access$400(r100).isEmpty() == true) goto L9;
            this.mIsolationEnable = true;
            return;
        }

        private boolean handleIsolationError(BaseException r110) {
            if (this.mIsolationEnable == true) goto L5;
        L19:
            return false;
        L5:
            if (this.mIsolationIndex >= NetworkFailoverStrategy.access$300(this.this$0)) goto L19;
            boolean r100 = NetworkFailoverStrategy.access$400(this.this$0).contains(Integer.valueOf(r110.getErrorCode()));
            if (r100 == false) goto L17;
            int r101 = this.mIsolationIndex + 1;
            this.mIsolationIndex = r101;
            if (r101 == NetworkFailoverStrategy.access$300(this.this$0)) goto L12;
            return true;
        L12:
            if (Logger.debug() == false) goto L14;
            Logger.taskDebug(NetworkFailoverStrategy.TAG, NetworkFailoverStrategy.access$200(this.this$0), "handleIsolationError", "IsolationCount" + NetworkFailoverStrategy.access$300(this.this$0) + " ttnetIsolationIndex:" + this.mIsolationIndex + " errorCode:" + r110.getErrorCode());
        L14:
            return false;
        L17:
            if (Logger.debug() == false) goto L19;
            Logger.taskDebug(NetworkFailoverStrategy.TAG, NetworkFailoverStrategy.access$200(this.this$0), "handleIsolationError", "IsMatch" + r100 + " ttnetIsolationIndex:" + this.mIsolationIndex + " errorCode:" + r110.getErrorCode());
            goto L19
        }

        private boolean handleIsolationHeader(List<HttpHeader> r100) {
            if (this.mIsolationEnable == true) goto L5;
        L22:
            return false;
        L5:
            if (this.mHandleCurrentIsolationHeader == false) goto L22;
            int r101 = this.mIsolationIndex;
            if (r101 < 0) goto L22;
            if (r101 >= NetworkFailoverStrategy.access$300(this.this$0)) goto L22;
            this.mHandleCurrentIsolationHeader = false;
            if (Logger.debug() == false) goto L14;
            Logger.taskDebug(NetworkFailoverStrategy.TAG, NetworkFailoverStrategy.access$200(this.this$0), "handleIsolationHeader", "Add handleIsolationHeader: https://dl");
        L14:
            r100.add(new HttpHeader("x-ttnet-isolation-info", NetworkFailoverStrategy.TTNET_ISOLATION_HEADER_VALUE));
            if (NetworkFailoverStrategy.access$500(this.this$0) > 0) goto L17;
            return true;
        L17:
            if (Logger.debug() == false) goto L19;
            Logger.taskDebug(NetworkFailoverStrategy.TAG, NetworkFailoverStrategy.access$200(this.this$0), "handleIsolationHeader", "Add x-ttnet-http-proto-type: " + NetworkFailoverStrategy.access$500(this.this$0));
        L19:
            DownloadHelper.removeHeaderKey(r100, DownloadHelper.TTNET_PROTO_TYPE);
            r100.add(new HttpHeader(DownloadHelper.TTNET_PROTO_TYPE, String.valueOf(NetworkFailoverStrategy.access$500(this.this$0))));
            return true;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.NetworkFailoverStrategy.DefaultIpChangeStrategyImpl, com.ss.android.socialbase.downloader.downloader.NetworkFailoverStrategy.FailoverStrategy
        public boolean handleError(BaseException r100) {
            boolean r101 = handleIsolationError(r100);
            this.mHandleCurrentIsolationHeader = r101;
            if (r101 == false) goto L6;
            super.handleError(r100);
        L6:
            return this.mHandleCurrentIsolationHeader;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.NetworkFailoverStrategy.DefaultIpChangeStrategyImpl, com.ss.android.socialbase.downloader.downloader.NetworkFailoverStrategy.FailoverStrategy
        public void handleHeader(List<HttpHeader> r100) {
            if (handleIsolationHeader(r100) == false) goto L6;
            super.handleHeader(r100);
            return;
        }
    }

    public class TimeoutStrategyImpl implements FailoverStrategy {
        private boolean mTimeoutEnable;
        private int mTimeoutIndex;
        final /* synthetic */ NetworkFailoverStrategy this$0;

        @Override // com.ss.android.socialbase.downloader.downloader.NetworkFailoverStrategy.FailoverStrategy
        public boolean isFailoverOnly() {
            return false;
        }

        public TimeoutStrategyImpl(NetworkFailoverStrategy r100) {
            this.this$0 = r100;
            this.mTimeoutEnable = false;
            this.mTimeoutIndex = -1;
            if (NetworkFailoverStrategy.access$900(r100).isEmpty() == false) goto L5;
            return;
        L5:
            if (NetworkFailoverStrategy.access$1000(r100).isEmpty() == true) goto L7;
        L8:
            this.mTimeoutEnable = true;
            return;
        L7:
            if (NetworkFailoverStrategy.access$1100(r100).isEmpty() == false) goto L8;
        }

        private boolean handleTimeoutError(BaseException r100) {
            if (this.mTimeoutEnable == true) goto L5;
            return false;
        L5:
            boolean r101 = NetworkFailoverStrategy.access$900(this.this$0).contains(Integer.valueOf(r100.getErrorCode()));
            if (r101 == false) goto L10;
            this.mTimeoutIndex++;
            return true;
        L10:
            if (Logger.debug() == false) goto L12;
            Logger.taskDebug(NetworkFailoverStrategy.TAG, NetworkFailoverStrategy.access$200(this.this$0), "handleTimeoutError", "IsMatch:" + r101 + " ttnetTimeoutIndex:" + this.mTimeoutIndex + " errorCode:" + r100.getErrorCode());
        L12:
            return false;
        }

        private void handleTimeoutHeader(List<HttpHeader> r100) {
            if (this.mTimeoutEnable == true) goto L5;
            return;
        L5:
            if (this.mTimeoutIndex >= 0) goto L8;
            return;
        L8:
            if (NetworkFailoverStrategy.access$1100(this.this$0).isEmpty() == true) goto L18;
            if (this.mTimeoutIndex >= NetworkFailoverStrategy.access$1100(this.this$0).size()) goto L12;
            int r101 = this.mTimeoutIndex;
        L13:
            String r102 = String.valueOf(ListProtector.get(NetworkFailoverStrategy.access$1100(this.this$0), r101));
            if (Logger.debug() == false) goto L16;
            Logger.taskDebug(NetworkFailoverStrategy.TAG, NetworkFailoverStrategy.access$200(this.this$0), "handleTimeoutHeader", "Add ConnectTimeout:".concat(r102));
        L16:
            r100.add(new HttpHeader(DownloadConstants.EXTRA_TTNET_CONNECT_TIMEOUT, r102));
            goto L18
        L12:
            r101 = NetworkFailoverStrategy.access$1100(this.this$0).size() - 1;
        L18:
            if (NetworkFailoverStrategy.access$1000(this.this$0).isEmpty() == false) goto L20;
            return;
        L20:
            if (this.mTimeoutIndex >= NetworkFailoverStrategy.access$1000(this.this$0).size()) goto L22;
            int r103 = this.mTimeoutIndex;
        L23:
            String r104 = String.valueOf(ListProtector.get(NetworkFailoverStrategy.access$1000(this.this$0), r103));
            if (Logger.debug() == false) goto L26;
            Logger.taskDebug(NetworkFailoverStrategy.TAG, NetworkFailoverStrategy.access$200(this.this$0), "handleTimeoutHeader", "Add IoTimeout:".concat(r104));
        L26:
            r100.add(new HttpHeader(DownloadConstants.EXTRA_TTNET_IO_TIMEOUT, r104));
            return;
        L22:
            r103 = NetworkFailoverStrategy.access$1000(this.this$0).size() - 1;
            goto L23
        }

        @Override // com.ss.android.socialbase.downloader.downloader.NetworkFailoverStrategy.FailoverStrategy
        public boolean handleError(BaseException r100) {
            return handleTimeoutError(r100);
        }

        @Override // com.ss.android.socialbase.downloader.downloader.NetworkFailoverStrategy.FailoverStrategy
        public void handleHeader(List<HttpHeader> r100) {
            handleTimeoutHeader(r100);
        }
    }

    public NetworkFailoverStrategy(DownloadInfo r110) {
        this.mIsolationErrorCodeSet = new HashSet();
        this.mIsolationCount = 0;
        this.mIsolationHttpProtoType = 0;
        this.mTimeoutErrorCodeSet = new HashSet();
        this.mConnectTimeoutList = new ArrayList();
        this.mIoTimeoutList = new ArrayList();
        this.mIpChangeErrorCodeSet = new HashSet();
        this.mIpChangeCountLimit = 0;
        this.mBackHostList = new ArrayList();
        this.mBackHostErrorCodeSet = new HashSet();
        this.mBackHostCountLimit = 0;
        this.mFailoverStrategyList = new ArrayList();
        this.mDownloadId = 0;
        initInternal(r110);     // Catch: Throwable -> L7
        if (Logger.debugScene(r110) == false) goto L15;
        Logger.taskDebug(TAG, r110, TAG, "Init ttnetIsolationCount:" + this.mIsolationCount + " mIsolationErrorCodeSet:" + this.mIsolationErrorCodeSet.toString() + " mIsolationHttpProtoType:" + this.mIsolationHttpProtoType + " ttnetTimeoutErrorCodes:" + this.mTimeoutErrorCodeSet.toString() + " ttnetConnectTimeout:" + this.mConnectTimeoutList.toString() + " ttnetIoTimeout:" + this.mIoTimeoutList.toString() + " ipChangeCountLimit:" + this.mIpChangeCountLimit + " ipChangeErrorCodeSet:" + this.mIpChangeErrorCodeSet + " host:" + this.mDownloadHost + " backHostList:" + this.mBackHostList.toString() + " backHostCountLimit:" + this.mBackHostCountLimit + " backHostErrorCodeSet:" + this.mBackHostErrorCodeSet);
    L15:
        this.mFailoverStrategyList.add(new TimeoutStrategyImpl(this));
        this.mFailoverStrategyList.add(new DefaultIpChangeStrategyImpl(this));
        this.mFailoverStrategyList.add(new IsolationIpChangeStrategyImpl(this));
        this.mFailoverStrategyList.add(new BackHostStrategyImpl(this));
        this.mFailoverStrategyList.add(new TimeoutStrategyImpl(this));
        return;
    L7:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L19
        Logger.taskError(TAG, this.mDownloadId, TAG, "Init Error" + th.toString());     // Catch: Throwable -> L17
        if (Logger.debugScene(r110) == false) goto L15;
        Logger.taskDebug(TAG, r110, TAG, "Init ttnetIsolationCount:" + this.mIsolationCount + " mIsolationErrorCodeSet:" + this.mIsolationErrorCodeSet.toString() + " mIsolationHttpProtoType:" + this.mIsolationHttpProtoType + " ttnetTimeoutErrorCodes:" + this.mTimeoutErrorCodeSet.toString() + " ttnetConnectTimeout:" + this.mConnectTimeoutList.toString() + " ttnetIoTimeout:" + this.mIoTimeoutList.toString() + " ipChangeCountLimit:" + this.mIpChangeCountLimit + " ipChangeErrorCodeSet:" + this.mIpChangeErrorCodeSet + " host:" + this.mDownloadHost + " backHostList:" + this.mBackHostList.toString() + " backHostCountLimit:" + this.mBackHostCountLimit + " backHostErrorCodeSet:" + this.mBackHostErrorCodeSet);
    L17:
        th = th;
        String r100 = " backHostErrorCodeSet:";
    L22:
        if (Logger.debugScene(r110) == false) goto L25;
        Throwable r111 = th;
        Logger.taskDebug(TAG, r110, TAG, "Init ttnetIsolationCount:" + this.mIsolationCount + " mIsolationErrorCodeSet:" + this.mIsolationErrorCodeSet.toString() + " mIsolationHttpProtoType:" + this.mIsolationHttpProtoType + " ttnetTimeoutErrorCodes:" + this.mTimeoutErrorCodeSet.toString() + " ttnetConnectTimeout:" + this.mConnectTimeoutList.toString() + " ttnetIoTimeout:" + this.mIoTimeoutList.toString() + " ipChangeCountLimit:" + this.mIpChangeCountLimit + " ipChangeErrorCodeSet:" + this.mIpChangeErrorCodeSet + " host:" + this.mDownloadHost + " backHostList:" + this.mBackHostList.toString() + " backHostCountLimit:" + this.mBackHostCountLimit + r100 + this.mBackHostErrorCodeSet);
        throw r111;
    L25:
        throw th;
    L19:
        th = th;
        r100 = " backHostErrorCodeSet:";
        goto L22
    }

    public static /* synthetic */ int access$000(NetworkFailoverStrategy r100) {
        return r100.mIpChangeCountLimit;
    }

    public static /* synthetic */ Set access$100(NetworkFailoverStrategy r100) {
        return r100.mIpChangeErrorCodeSet;
    }

    public static /* synthetic */ List access$1000(NetworkFailoverStrategy r100) {
        return r100.mIoTimeoutList;
    }

    public static /* synthetic */ List access$1100(NetworkFailoverStrategy r100) {
        return r100.mConnectTimeoutList;
    }

    public static /* synthetic */ int access$200(NetworkFailoverStrategy r100) {
        return r100.mDownloadId;
    }

    public static /* synthetic */ int access$300(NetworkFailoverStrategy r100) {
        return r100.mIsolationCount;
    }

    public static /* synthetic */ Set access$400(NetworkFailoverStrategy r100) {
        return r100.mIsolationErrorCodeSet;
    }

    public static /* synthetic */ int access$500(NetworkFailoverStrategy r100) {
        return r100.mIsolationHttpProtoType;
    }

    public static /* synthetic */ int access$600(NetworkFailoverStrategy r100) {
        return r100.mBackHostCountLimit;
    }

    public static /* synthetic */ List access$700(NetworkFailoverStrategy r100) {
        return r100.mBackHostList;
    }

    public static /* synthetic */ Set access$800(NetworkFailoverStrategy r100) {
        return r100.mBackHostErrorCodeSet;
    }

    public static /* synthetic */ Set access$900(NetworkFailoverStrategy r100) {
        return r100.mTimeoutErrorCodeSet;
    }

    private void initInternal(DownloadInfo r100) throws Throwable {
        if (r100 == null) goto L5;
        this.mDownloadId = r100.getId();
        this.mDownloadHost = new URL(r100.getUrl()).getHost();
        JSONObject r101 = DownloadSetting.obtain(this.mDownloadId).optJSONObject(DownloadSettingKeys.NETWORK_FAILOVER_STRATEGY);
    L6:
        if (r101 != null) goto L8;
        return;
    L8:
        int r102 = r101.optInt(DownloadSettingKeys.NetworkFailoverStrategy.KEY_TTNET_BACK_HOST_COUNT_LIMIT);
        if (r102 <= 0) goto L11;
        this.mBackHostCountLimit = r102;
    L11:
        JSONArray r103 = r101.optJSONArray(DownloadSettingKeys.NetworkFailoverStrategy.KEY_TTNET_BACK_HOST);
        int r104 = 0;
        if (TextUtils.isEmpty(this.mDownloadHost) == true) goto L40;
        if (r103 == null) goto L40;
        if (r103.length() <= 0) goto L40;
        int r105 = 0;
    L18:
        if (r105 >= r103.length()) goto L40;
        String r106 = r103.optString(r105);
        if (TextUtils.isEmpty(r106) == true) goto L39;
        String[] r107 = r106.split(":");
        if (r107 == null) goto L39;
        if (r107.length != 2) goto L39;
        if (this.mDownloadHost.equals(r107[0]) == false) goto L39;
        if (TextUtils.isEmpty(r107[1]) == true) goto L39;
        String[] r108 = r107[1].split(",");
        if (r108 == null) goto L40;
        if (r108.length <= 0) goto L40;
        int r109 = r108.length;
        int r110 = 0;
    L34:
        if (r110 >= r109) goto L40;
        String r111 = r108[r110];
        if (TextUtils.isEmpty(r111) == true) goto L38;
        this.mBackHostList.add(r111);
    L38:
        r110 = r110 + 1;
    L39:
        r105 = r105 + 1;
    L40:
        JSONArray r112 = r101.optJSONArray(DownloadSettingKeys.NetworkFailoverStrategy.KEY_TTNET_BACK_HOST_ERROR_CODE);
        if (r112 != null) goto L43;
    L51:
        int r113 = r101.optInt(DownloadSettingKeys.NetworkFailoverStrategy.KEY_TTNET_ISOLATION_COUNT);
        if (r113 <= 0) goto L54;
        this.mIsolationCount = r113;
    L54:
        JSONArray r114 = r101.optJSONArray(DownloadSettingKeys.NetworkFailoverStrategy.KEY_TTNET_ISOLATION_ERROR_CODE);
        if (r114 != null) goto L57;
    L65:
        int r115 = r101.optInt(DownloadSettingKeys.NetworkFailoverStrategy.KEY_TTNET_ISOLATION_HTTP_PROTO_TYPE);
        if (1 == r115) goto L70;
        if (2 == r115) goto L70;
        if (3 == r115) goto L70;
    L71:
        JSONArray r116 = r101.optJSONArray(DownloadSettingKeys.NetworkFailoverStrategy.KEY_TTNET_TIMEOUT_ERROR_CODE);
        if (r116 != null) goto L74;
    L82:
        JSONArray r117 = r101.optJSONArray(DownloadSettingKeys.NetworkFailoverStrategy.KEY_TTNET_TIMEOUT_CONNECT);
        if (r117 != null) goto L85;
    L93:
        JSONArray r118 = r101.optJSONArray(DownloadSettingKeys.NetworkFailoverStrategy.KEY_TTNET_TIMEOUT_IO);
        if (r118 != null) goto L96;
    L104:
        JSONArray r119 = r101.optJSONArray(DownloadSettingKeys.NetworkFailoverStrategy.KEY_TTNET_IP_CHANGE_ERROR_CODE);
        if (r119 != null) goto L107;
    L114:
        int r120 = r101.optInt(DownloadSettingKeys.NetworkFailoverStrategy.KEY_TTNET_IP_CHANGE_COUNT_LIMIT);
        if (r120 <= 0) goto L146;
        this.mIpChangeCountLimit = r120;
        return;
    L146:
        return;
    L107:
        if (r119.length() <= 0) goto L114;
    L109:
        if (r104 >= r119.length()) goto L114;
        int r121 = r119.optInt(r104);
        if (r121 <= 0) goto L113;
        this.mIpChangeErrorCodeSet.add(Integer.valueOf(r121));
    L113:
        r104 = r104 + 1;
        goto L109
    L96:
        if (r118.length() <= 0) goto L104;
        int r122 = 0;
    L99:
        if (r122 >= r118.length()) goto L104;
        long r123 = r118.optLong(r122);
        if (r123 <= 0) goto L103;
        this.mIoTimeoutList.add(Long.valueOf(r123));
    L103:
        r122 = r122 + 1;
        goto L99
    L85:
        if (r117.length() <= 0) goto L93;
        int r124 = 0;
    L88:
        if (r124 >= r117.length()) goto L93;
        long r125 = r117.optLong(r124);
        if (r125 <= 0) goto L92;
        this.mConnectTimeoutList.add(Long.valueOf(r125));
    L92:
        r124 = r124 + 1;
        goto L88
    L74:
        if (r116.length() <= 0) goto L82;
        int r126 = 0;
    L77:
        if (r126 >= r116.length()) goto L82;
        int r127 = r116.optInt(r126);
        if (r127 <= 0) goto L81;
        this.mTimeoutErrorCodeSet.add(Integer.valueOf(r127));
    L81:
        r126 = r126 + 1;
    L70:
        this.mIsolationHttpProtoType = r115;
        goto L71
    L57:
        if (r114.length() <= 0) goto L65;
        int r128 = 0;
    L60:
        if (r128 >= r114.length()) goto L65;
        int r129 = r114.optInt(r128);
        if (r129 <= 0) goto L64;
        this.mIsolationErrorCodeSet.add(Integer.valueOf(r129));
    L64:
        r128 = r128 + 1;
        goto L60
    L43:
        if (r112.length() <= 0) goto L51;
        int r130 = 0;
    L46:
        if (r130 >= r112.length()) goto L51;
        int r131 = r112.optInt(r130);
        if (r131 <= 0) goto L50;
        this.mBackHostErrorCodeSet.add(Integer.valueOf(r131));
    L50:
        r130 = r130 + 1;
        goto L46
    L5:
        r101 = DownloadSetting.obtainGlobal().optJSONObject(DownloadSettingKeys.NETWORK_FAILOVER_STRATEGY);
        goto L6
    }

    public void handleError(BaseException r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        Iterator<FailoverStrategy> r101 = this.mFailoverStrategyList.iterator();
    L6:
        if (r101.hasNext() == false) goto L10;
        FailoverStrategy r102 = r101.next();
        boolean r103 = r102.handleError(r100);
        if (r102.isFailoverOnly() == false) goto L6;
        if (r103 == false) goto L6;
        return;
    }

    public void handleHeader(List<HttpHeader> r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        Iterator<FailoverStrategy> r101 = this.mFailoverStrategyList.iterator();
    L6:
        if (r101.hasNext() == false) goto L8;
        r101.next().handleHeader(r100);
        goto L6
    }
}
