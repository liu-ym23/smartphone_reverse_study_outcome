package com.bytedance.ee.bear.document.ai.citation;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.widget.utils.SingleLiveEvent;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001f2\u00020\u0001:\u0002\u001f B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0006J\u000e\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0019J\u0006\u0010\u001a\u001a\u00020\u0015J&\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b2\u0006\u0010\u001c\u001a\u00020\f2\b\b\u0002\u0010\u001d\u001a\u00020\fJ\u0018\u0010\u001e\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\f2\b\b\u0002\u0010\u001d\u001a\u00020\fR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR#\u0010\t\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\n¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/bytedance/ee/bear/document/ai/citation/DocAICitationViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "citationData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/bytedance/ee/bear/document/ai/citation/ShowCitationData;", "getCitationData", "()Landroidx/lifecycle/MutableLiveData;", "callbackEvent", "Lcom/ss/android/lark/widget/utils/SingleLiveEvent;", "Lkotlin/Pair;", "", "getCallbackEvent", "()Lcom/ss/android/lark/widget/utils/SingleLiveEvent;", "uiEvent", "Lcom/bytedance/ee/bear/document/ai/citation/DocAICitationViewModel$UiEvent;", "getUiEvent", "isSendClosedNotice", "", "updateData", "", "data", "onCitationClick", "citation", "Lcom/bytedance/ee/bear/document/ai/citation/Citation;", "onDeleteClick", "buildCallbackEvent", "type", "id", "citationCallback", "Companion", "UiEvent", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DocAICitationViewModel extends ViewModel {
    public static final a Companion = null;
    private static final String TAG = null;
    private final SingleLiveEvent<Pair<String, String>> callbackEvent;
    private final MutableLiveData<ShowCitationData> citationData;
    private boolean isSendClosedNotice;
    private final SingleLiveEvent<b> uiEvent;

    public static final class a {
        public a() {
        }
    }

    public static abstract class b {

        public static final class a extends b {
            public final Citation a;

            public final boolean equals(Object r4) {
                if (this != r4) goto L6;
                return true;
            L6:
                if ((r4 instanceof a) == true) goto L9;
                return false;
            L9:
                if (Intrinsics.areEqual(this.a, ((a) r4).a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                return this.a.hashCode();
            }

            public final String toString() {
                return "OpenCitation(citation=" + this.a + ')';
            }

            public a(Citation r2) {
                Intrinsics.checkNotNullParameter(r2, "citation");
                this.a = r2;
            }
        }

        /* JADX INFO: renamed from: com.bytedance.ee.bear.document.ai.citation.DocAICitationViewModel$b$b, reason: collision with other inner class name */
        public static final class C0050b extends b {
            public static final C0050b a = null;

            static {
                a = new C0050b();
            }

            public C0050b() {
            }
        }

        public b() {
        }
    }

    static {
        Companion = new a();
        TAG = "DocAICitationViewModel";
    }

    public final void onDeleteClick() {
        Log.i(TAG, "onDeleteClick");
        this.isSendClosedNotice = false;
        this.uiEvent.setValue(b.C0050b.a);
    }

    public DocAICitationViewModel() {
        this.citationData = new MutableLiveData();
        this.callbackEvent = new SingleLiveEvent();
        this.uiEvent = new SingleLiveEvent();
        this.isSendClosedNotice = true;
    }

    public static final /* synthetic */ String access$getTAG$cp() {
        return TAG;
    }

    public final SingleLiveEvent<Pair<String, String>> getCallbackEvent() {
        return this.callbackEvent;
    }

    public final MutableLiveData<ShowCitationData> getCitationData() {
        return this.citationData;
    }

    public final SingleLiveEvent<b> getUiEvent() {
        return this.uiEvent;
    }

    public final void onCitationClick(Citation r4) {
        Intrinsics.checkNotNullParameter(r4, "citation");
        String r0 = r4.getUrl();
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L12;
        Log.e(TAG, "onCitationClick: url is empty");
        return;
    L12:
        Log.i(TAG, "onCitationClick: click type: " + r4.getUrlType());
        this.uiEvent.setValue(new b.a(r4));
        return;
    L5:
        if (r0.length() == 0) goto L8;
        r1 = false;
        goto L9
    }

    public final void updateData(ShowCitationData r2) {
        Intrinsics.checkNotNullParameter(r2, "data");
        this.citationData.setValue(r2);
    }

    public final Pair<String, String> buildCallbackEvent(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "type");
        Intrinsics.checkNotNullParameter(r3, "id");
        if (Intrinsics.areEqual(r2, DocAICitationClickType.Close.getType()) == false) goto L9;
        if (this.isSendClosedNotice == true) goto L9;
        Log.e(TAG, "citationCallback: close notice is not send");
        this.isSendClosedNotice = true;
        return null;
    L9:
        return new Pair(r3, r2);
    }

    public final void citationCallback(String r5, String r6) {
        Intrinsics.checkNotNullParameter(r5, "type");
        Intrinsics.checkNotNullParameter(r6, "id");
        Pair<String, String> r0 = buildCallbackEvent(r5, r6);
        if (r0 != null) goto L5;
        return;
    L5:
        Log.i(TAG, "citationCallback: " + r6 + ' ' + r5);
        this.callbackEvent.setValue(r0);
    }

    public static /* synthetic */ Pair buildCallbackEvent$default(DocAICitationViewModel r0, String r1, String r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L11;
        ShowCitationData r5 = (ShowCitationData) r0.citationData.getValue();
        if (r5 == null) goto L7;
        r2 = r5.getId();
    L8:
        if (r2 != null) goto L11;
        r2 = "";
        goto L11
    L7:
        r2 = null;
    L11:
        return r0.buildCallbackEvent(r1, r2);
    }

    public static /* synthetic */ void citationCallback$default(DocAICitationViewModel r0, String r1, String r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L10;
        ShowCitationData r5 = (ShowCitationData) r0.citationData.getValue();
        if (r5 == null) goto L7;
        r2 = r5.getId();
    L8:
        if (r2 != null) goto L10;
        r2 = "";
        goto L10
    L7:
        r2 = null;
    L10:
        r0.citationCallback(r1, r2);
    }
}
