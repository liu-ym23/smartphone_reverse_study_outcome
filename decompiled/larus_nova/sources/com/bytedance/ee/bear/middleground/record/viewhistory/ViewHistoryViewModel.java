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

/* JADX INFO: loaded from: classes18.dex */
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

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ViewHistoryViewModel f234373a;

        public a(ViewHistoryViewModel r100) {
            this.f234373a = r100;
        }

        @Override // xi5.f.c
        public final void a(RecordListResult r100) {
            ViewHistoryViewModel.access$002(this.f234373a, null);
            ViewHistoryViewModel.access$100(this.f234373a).setValue(new b(0));
            ViewHistoryViewModel.access$202(this.f234373a, r100.nextPageToken);
            ViewHistoryViewModel.access$300(this.f234373a).setValue(r100);
            if (TextUtils.isEmpty(ViewHistoryViewModel.access$200(this.f234373a)) == false) goto L6;
            ViewHistoryViewModel.access$402(this.f234373a, true);
        L6:
            if (ViewHistoryViewModel.access$500(this.f234373a) == false) goto L11;
            if (r100.users.size() != 0) goto L11;
            ViewHistoryViewModel.access$100(this.f234373a).setValue(new b(5));
        L11:
            if (ViewHistoryViewModel.access$400(this.f234373a) == false) goto L13;
            ViewHistoryViewModel.access$100(this.f234373a).setValue(new b(4));
        L13:
            tt5.a.h(ViewHistoryViewModel.TAG, "pull: success");
            ViewHistoryViewModel.access$502(this.f234373a, false);
        }

        @Override // xi5.f.c
        public final void onError(Throwable r100) {
            ViewHistoryViewModel.access$002(this.f234373a, null);
            if ((r100 instanceof NetService.ServerErrorException) == true) goto L24;
            tt5.a.e(ViewHistoryViewModel.TAG, "pull: fail", r100, false);
            if (ViewHistoryViewModel.access$500(this.f234373a) == false) goto L21;
            ViewHistoryViewModel.access$100(this.f234373a).setValue(new b(2));
            return;
        L21:
            ViewHistoryViewModel.access$100(this.f234373a).setValue(new b(3));
            return;
        L24:
            int r101 = new JSONObject(((NetService.ServerErrorException) r100).getJson()).optInt("code");     // Catch: JSONException -> L16
            if (r101 != 7) goto L8;
            tt5.a.h(ViewHistoryViewModel.TAG, "pull: no access");     // Catch: JSONException -> L16
            ViewHistoryViewModel.access$100(this.f234373a).setValue(new b(7));     // Catch: JSONException -> L16
        L23:
            return;
        L8:
            if (r101 != 8) goto L10;
            tt5.a.h(ViewHistoryViewModel.TAG, "pull: no admin");     // Catch: JSONException -> L16
            ViewHistoryViewModel.access$100(this.f234373a).setValue(new b(8));     // Catch: JSONException -> L16
            goto L23
        L10:
            if (r101 == 9) goto L12;
            tt5.a.h(ViewHistoryViewModel.TAG, "pull: fail");     // Catch: JSONException -> L16
            ViewHistoryViewModel.access$100(this.f234373a).setValue(new b(2));     // Catch: JSONException -> L16
            goto L23
        L12:
            tt5.a.h(ViewHistoryViewModel.TAG, "pull: no privacy");     // Catch: JSONException -> L16
            ViewHistoryViewModel.access$100(this.f234373a).setValue(new b(9));     // Catch: JSONException -> L16
        L16:
            e = move-exception;
            e.printStackTrace();
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f234374a;

        public b(int r100) {
            this.f234374a = r100;
        }
    }

    public void pull() {
        if (this.isFinish == false) goto L6;
        tt5.a.h(TAG, "pull: finish");
        this.mLoadingMoreState.setValue(new b(0));
        return;
    L6:
        Disposable r100 = this.mPullDisposable;
        if (r100 == null) goto L10;
        r100.dispose();
        this.mPullDisposable = null;
    L10:
        if (this.isStart == false) goto L13;
        tt5.a.h(TAG, "pull: loading");
        this.mLoadingMoreState.setValue(new b(1));
    L13:
        if (j.a.f217090a.getNetworkState().a() == true) goto L19;
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

    public static /* synthetic */ MutableLiveData access$100(ViewHistoryViewModel r100) {
        return r100.mLoadingMoreState;
    }

    public static /* synthetic */ String access$200(ViewHistoryViewModel r100) {
        return r100.nextPageToken;
    }

    public static /* synthetic */ MutableLiveData access$300(ViewHistoryViewModel r100) {
        return r100.resultMutableLiveData;
    }

    public static /* synthetic */ boolean access$400(ViewHistoryViewModel r100) {
        return r100.isFinish;
    }

    public static /* synthetic */ boolean access$500(ViewHistoryViewModel r100) {
        return r100.isStart;
    }

    public static /* synthetic */ Disposable access$002(ViewHistoryViewModel r100, Disposable r101) {
        r100.mPullDisposable = r101;
        return r101;
    }

    public static /* synthetic */ String access$202(ViewHistoryViewModel r100, String r101) {
        r100.nextPageToken = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$402(ViewHistoryViewModel r100, boolean r101) {
        r100.isFinish = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$502(ViewHistoryViewModel r100, boolean r101) {
        r100.isStart = r101;
        return r101;
    }

    public void attach(String r100, int r101) {
        this.token = r100;
        this.objType = r101;
        this.isStart = true;
        this.isFinish = false;
        this.nextPageToken = "";
        this.mGetRecordListExecutor = new f();
    }
}
