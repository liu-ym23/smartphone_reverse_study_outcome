package com.bytedance.ee.bear.middleground.record.viewhistory;

import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.j;
import io.reactivex.disposables.Disposable;
import org.json.JSONException;
import org.json.JSONObject;
import xi5.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class ViewHistoryViewModel extends ViewModel {
    private static final String TAG = "ViewHistoryViewModel";
    private boolean isFinish;
    private boolean isStart;
    private f mGetRecordListExecutor;
    private MutableLiveData<b> mLoadingMoreState;
    private Disposable mPullDisposable;
    private String nextPageToken;
    private int objType;
    private final int pageSize;
    private MutableLiveData<RecordListResult> resultMutableLiveData;
    private String token;

    public class a implements f.c {
        public final /* synthetic */ ViewHistoryViewModel a;

        public a(ViewHistoryViewModel r1) {
            this.a = r1;
        }

        @Override // xi5.f.c
        public final void a(RecordListResult r4) {
            ViewHistoryViewModel.access$002(this.a, null);
            ViewHistoryViewModel.access$100(this.a).setValue(new b(0));
            ViewHistoryViewModel.access$202(this.a, r4.nextPageToken);
            ViewHistoryViewModel.access$300(this.a).setValue(r4);
            if (TextUtils.isEmpty(ViewHistoryViewModel.access$200(this.a)) == false) goto L6;
            ViewHistoryViewModel.access$402(this.a, true);
        L6:
            if (ViewHistoryViewModel.access$500(this.a) == false) goto L11;
            if (r4.users.size() != 0) goto L11;
            ViewHistoryViewModel.access$100(this.a).setValue(new b(5));
        L11:
            if (ViewHistoryViewModel.access$400(this.a) == false) goto L13;
            ViewHistoryViewModel.access$100(this.a).setValue(new b(4));
        L13:
            tt5.a.h(ViewHistoryViewModel.TAG, "pull: success");
            ViewHistoryViewModel.access$502(this.a, false);
        }

        @Override // xi5.f.c
        public final void onError(Throwable r5) {
            ViewHistoryViewModel.access$002(this.a, null);
            if ((r5 instanceof NetService.ServerErrorException) == true) goto L24;
            tt5.a.e(ViewHistoryViewModel.TAG, "pull: fail", r5, false);
            if (ViewHistoryViewModel.access$500(this.a) == false) goto L21;
            ViewHistoryViewModel.access$100(this.a).setValue(new b(2));
            return;
        L21:
            ViewHistoryViewModel.access$100(this.a).setValue(new b(3));
            return;
        L24:
            int r6 = new JSONObject(((NetService.ServerErrorException) r5).getJson()).optInt("code");     // Catch: JSONException -> L16
            if (r6 != 7) goto L8;
            tt5.a.h(ViewHistoryViewModel.TAG, "pull: no access");     // Catch: JSONException -> L16
            ViewHistoryViewModel.access$100(this.a).setValue(new b(7));     // Catch: JSONException -> L16
        L23:
            return;
        L8:
            if (r6 != 8) goto L10;
            tt5.a.h(ViewHistoryViewModel.TAG, "pull: no admin");     // Catch: JSONException -> L16
            ViewHistoryViewModel.access$100(this.a).setValue(new b(8));     // Catch: JSONException -> L16
            goto L23
        L10:
            if (r6 == 9) goto L12;
            tt5.a.h(ViewHistoryViewModel.TAG, "pull: fail");     // Catch: JSONException -> L16
            ViewHistoryViewModel.access$100(this.a).setValue(new b(2));     // Catch: JSONException -> L16
            goto L23
        L12:
            tt5.a.h(ViewHistoryViewModel.TAG, "pull: no privacy");     // Catch: JSONException -> L16
            ViewHistoryViewModel.access$100(this.a).setValue(new b(9));     // Catch: JSONException -> L16
        L16:
            e = move-exception;
            e.printStackTrace();
        }
    }

    public static class b {
        public final int a;

        public b(int r1) {
            this.a = r1;
        }
    }

    public void pull() {
        if (this.isFinish == false) goto L6;
        tt5.a.h(TAG, "pull: finish");
        this.mLoadingMoreState.setValue(new b(0));
        return;
    L6:
        Disposable r0 = this.mPullDisposable;
        if (r0 == null) goto L10;
        r0.dispose();
        this.mPullDisposable = null;
    L10:
        if (this.isStart == false) goto L13;
        tt5.a.h(TAG, "pull: loading");
        this.mLoadingMoreState.setValue(new b(1));
    L13:
        if (j.a.a.getNetworkState().a() == true) goto L19;
        tt5.a.b(TAG, "pull: no network");
        if (this.isStart == false) goto L17;
        this.mLoadingMoreState.setValue(new b(2));
        return;
    L17:
        this.mLoadingMoreState.setValue(new b(3));
        return;
    L19:
        this.mPullDisposable = this.mGetRecordListExecutor.a(new xi5.a(this.token, this.objType, this.nextPageToken, 20, this.isStart), new a(this));
    }

    public ViewHistoryViewModel() {
        this.pageSize = 20;
        this.isStart = true;
        this.isFinish = false;
        this.resultMutableLiveData = new MutableLiveData();
        this.mLoadingMoreState = new MutableLiveData();
    }

    public MutableLiveData<RecordListResult> getResultMutableLiveData() {
        return this.resultMutableLiveData;
    }

    public MutableLiveData<b> getmLoadingMoreState() {
        return this.mLoadingMoreState;
    }

    public static /* synthetic */ MutableLiveData access$100(ViewHistoryViewModel r0) {
        return r0.mLoadingMoreState;
    }

    public static /* synthetic */ String access$200(ViewHistoryViewModel r0) {
        return r0.nextPageToken;
    }

    public static /* synthetic */ MutableLiveData access$300(ViewHistoryViewModel r0) {
        return r0.resultMutableLiveData;
    }

    public static /* synthetic */ boolean access$400(ViewHistoryViewModel r0) {
        return r0.isFinish;
    }

    public static /* synthetic */ boolean access$500(ViewHistoryViewModel r0) {
        return r0.isStart;
    }

    public static /* synthetic */ Disposable access$002(ViewHistoryViewModel r0, Disposable r1) {
        r0.mPullDisposable = r1;
        return r1;
    }

    public static /* synthetic */ String access$202(ViewHistoryViewModel r0, String r1) {
        r0.nextPageToken = r1;
        return r1;
    }

    public static /* synthetic */ boolean access$402(ViewHistoryViewModel r0, boolean r1) {
        r0.isFinish = r1;
        return r1;
    }

    public static /* synthetic */ boolean access$502(ViewHistoryViewModel r0, boolean r1) {
        r0.isStart = r1;
        return r1;
    }

    public void attach(String r1, int r2) {
        this.token = r1;
        this.objType = r2;
        this.isStart = true;
        this.isFinish = false;
        this.nextPageToken = "";
        this.mGetRecordListExecutor = new f();
    }
}
