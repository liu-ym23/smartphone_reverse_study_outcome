package com.ss.bduploader.net;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.ss.bduploader.BDUploadLog;
import java.util.HashMap;

/* JADX INFO: loaded from: classes40.dex */
public class BDUploadHostProcessor {
    private static final int BACKUP_DNS = 1;
    private static final int MAIN_DNS = 0;
    public static final int MSG_IS_BACUP_PARSE = 1;
    public static final int MSG_IS_MAIN_PARSE = 0;
    public static final int STATE_IS_IDLE = 0;
    public static final int STATE_IS_PARSE_END_ERROR = 2;
    public static final int STATE_IS_PARSE_END_SUC = 3;
    public static final int STATE_IS_WAIT_RESULT = 1;
    private static final String TAG = "BDUploadHostProcessor";
    private int mBackUpDelayedTime;
    private int mBackUpType;
    private Handler mHandler;
    public String mHost;
    public HashMap<BDUploadDNSParserListener, Integer> mListeners;
    private int mMainType;
    private BaseDNS[] mParsers;
    private int[] mStates;

    public boolean isEnd() {
        int r100 = 0;
    L4:
        if (r100 >= 2) goto L12;
        if (this.mParsers[r100] == null) goto L11;
        int r101 = this.mStates[r100];
        if (r101 == 3) goto L11;
        if (r101 == 2) goto L11;
        return false;
    L11:
        r100 = r100 + 1;
        goto L4
    L12:
        BDUploadLog.d(TAG, "all dns parse is end");
        return true;
    }

    public boolean isValidSourceId(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L6;
        BDUploadLog.d(TAG, String.format("id: %s is empty", new Object[]{r100}));
        return false;
    L6:
        int r101 = 0;
    L8:
        if (r101 >= 2) goto L16;
        BaseDNS r102 = this.mParsers[r101];
        if (r102 == null) goto L15;
        if (r100.equals(r102.mId) == false) goto L15;
        BDUploadLog.d(TAG, String.format("id: %s is valid index: %d", new Object[]{r100, Integer.valueOf(r101)}));
        return true;
    L15:
        r101 = r101 + 1;
        goto L8
    L16:
        BDUploadLog.d(TAG, String.format("id: %s is valid", new Object[]{r100}));
        return false;
    }

    private void doParseInternal(int r100, BDUploadDNSInfo r101) {
        BDUploadLog.d(TAG, String.format("----do parse internal what:%d info:%s", new Object[]{Integer.valueOf(r100), r101}));
        if (r101 != null) goto L5;
        return;
    L5:
        if (r100 == 0) goto L7;
    L11:
        if (r100 == 1) goto L13;
    L15:
        BDUploadLog.d(TAG, String.format("****do parse internal end", new Object[0]));
        return;
    L13:
        if (this.mParsers[1] != null) goto L15;
        BDUploadLog.d(TAG, String.format("create backup dns type:%d host:%s", new Object[]{Integer.valueOf(this.mMainType), r101.mHost}));
        this.mStates[1] = 1;
        this.mParsers[1] = createDNSParser(r101.mHost, this.mBackUpType, 1);
        this.mParsers[1].start();
        goto L15
    L7:
        if (this.mParsers[0] != null) goto L11;
        BDUploadLog.d(TAG, String.format("create main dns type:%d host:%s", new Object[]{Integer.valueOf(this.mMainType), r101.mHost}));
        this.mStates[0] = 1;
        this.mParsers[0] = createDNSParser(r101.mHost, this.mMainType, 0);
        this.mParsers[0].start();
        Message r102 = new Message();
        r102.what = 1;
        r102.obj = r101;
        if (this.mBackUpDelayedTime <= 0) goto L15;
        BDUploadLog.d(TAG, String.format("BackUpDelayedTime:%d send backup delay first", new Object[]{Integer.valueOf(this.mMainType)}));
        this.mHandler.sendMessageDelayed(r102, this.mBackUpDelayedTime * 1000);
        goto L15
    }

    public void processMsg(int r100, BDUploadDNSInfo r101) {
        BDUploadLog.d(TAG, String.format("----processor pro msg what:%d host:%s info:%s", new Object[]{Integer.valueOf(r100), r101.mHost, r101}));
        if (r100 == 0) goto L14;
        if (r100 != 1) goto L16;
        int[] r102 = this.mStates;
        int r103 = r102[0];
        if (r103 == 1) goto L11;
        if (r103 == 2) goto L11;
        if (r103 != 3) goto L16;
    L11:
        if (r102[1] != 0) goto L16;
        BDUploadLog.d(TAG, String.format("main dns is not end and backup dns is idle call backup dns", new Object[0]));
        doParseInternal(r100, r101);
    L16:
        BDUploadLog.d(TAG, String.format("****end processor pro msg what:%d host:%s info:%s", new Object[]{Integer.valueOf(r100), r101.mHost, r101}));
        return;
    L14:
        if (this.mStates[0] != 0) goto L16;
        BDUploadLog.d(TAG, String.format("main dns is idle call main dns", new Object[0]));
        doParseInternal(r100, r101);
        goto L16
    }

    public void processResult(int r110, BDUploadDNSInfo r111) {
        BDUploadLog.d(TAG, String.format("----process result what:%d id:%s host:%s", new Object[]{Integer.valueOf(r110), r111.mId, r111.mHost}));
        if (r110 == 2) goto L6;
        if (r110 == 3) goto L6;
        String r100 = null;
    L8:
        if (TextUtils.isEmpty(r100) == false) goto L11;
        BDUploadLog.d(TAG, String.format("****process result err id is empty", new Object[0]));
        return;
    L11:
        int r101 = 0;
    L12:
        if (r101 >= 2) goto L24;
        BaseDNS r102 = this.mParsers[r101];
        if (r102 == null) goto L23;
        if (r100.equals(r102.mId) == false) goto L23;
        this.mParsers[r101].close();
        this.mParsers[r101] = null;
        if (r110 != 3) goto L20;
        this.mStates[r101] = 3;
    L22:
        BDUploadLog.d(TAG, String.format("****process result parser index:%d is end, be close", new Object[]{Integer.valueOf(r101)}));
        goto L24
    L20:
        if (r110 != 2) goto L22;
        this.mStates[r101] = 2;
    L23:
        r101 = r101 + 1;
    L24:
        if (r101 != 0) goto L27;
        if (r110 != 2) goto L27;
        BDUploadLog.d(TAG, String.format("mian dns parse error, try back up dns", new Object[0]));
        processMsg(1, new BDUploadDNSInfo(BDUploadDNSParser.mGlobalBackType, r111.mHost, null, 0, null));
    L27:
        BDUploadLog.d(TAG, String.format("****end process result what:%d id:%s host:%s", new Object[]{Integer.valueOf(r110), r111.mId, r111.mHost}));
        return;
    L6:
        r100 = r111.mId;
        goto L8
    }

    private BaseDNS createDNSParser(String r100, int r101, int r102) {
        if (r101 == 1) goto L9;
        if (r101 == 2) goto L9;
        if (r101 == 3) goto L9;
        BDUploadLog.d(TAG, String.format("create local dns parser for host:%s type:%d", new Object[]{r100, Integer.valueOf(r101)}));
        return new LocalDNS(r100, this.mHandler);
    L9:
        BDUploadLog.d(TAG, String.format("create http dns parser for host:%s type:%d", new Object[]{r100, Integer.valueOf(r101)}));
        return new HTTPDNS(r100, null, r101, this.mHandler);
    }

    public BDUploadHostProcessor(String r100, Handler r101, int r102, int r103, int r104) {
        this.mMainType = r102;
        this.mBackUpType = r103;
        this.mHandler = r101;
        this.mHost = r100;
        this.mBackUpDelayedTime = r104;
        this.mStates = new int[2];
        this.mParsers = new BaseDNS[2];
        int r105 = 0;
    L3:
        if (r105 >= 2) goto L5;
        this.mParsers[r105] = null;
        r105 = r105 + 1;
        goto L3
    L5:
        int r106 = 0;
    L6:
        if (r106 >= 2) goto L8;
        this.mStates[r106] = 0;
        r106 = r106 + 1;
        goto L6
    L8:
        this.mListeners = new HashMap();
    }
}
