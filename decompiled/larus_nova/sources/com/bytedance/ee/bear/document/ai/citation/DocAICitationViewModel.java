package com.bytedance.ee.bear.document.ai.citation;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.widget.utils.SingleLiveEvent;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
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

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final Citation f218749a;

            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof a) == true) goto L9;
                return false;
            L9:
                if (Intrinsics.areEqual(this.f218749a, ((a) r100).f218749a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                return this.f218749a.hashCode();
            }

            public final String toString() {
                return "OpenCitation(citation=" + this.f218749a + ')';
            }

            public a(Citation r100) {
                Intrinsics.checkNotNullParameter(r100, "citation");
                this.f218749a = r100;
            }
        }

        /* JADX INFO: renamed from: com.bytedance.ee.bear.document.ai.citation.DocAICitationViewModel$b$b, reason: collision with other inner class name */
        public static final class C3106b extends b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C3106b f218750a = null;

            static {
                f218750a = new C3106b();
            }

            public C3106b() {
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
        this.uiEvent.setValue(b.C3106b.f218750a);
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

    public final void onCitationClick(Citation r100) {
        Intrinsics.checkNotNullParameter(r100, "citation");
        String r101 = r100.getUrl();
        if (r101 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == false) goto L12;
        Log.e(TAG, "onCitationClick: url is empty");
        return;
    L12:
        Log.i(TAG, "onCitationClick: click type: " + r100.getUrlType());
        this.uiEvent.setValue(new b.a(r100));
        return;
    L5:
        if (r101.length() == 0) goto L8;
        r102 = false;
        goto L9
    }

    public final void updateData(ShowCitationData r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        this.citationData.setValue(r100);
    }

    public final Pair<String, String> buildCallbackEvent(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r101, "id");
        if (Intrinsics.areEqual(r100, DocAICitationClickType.Close.getType()) == false) goto L9;
        if (this.isSendClosedNotice == true) goto L9;
        Log.e(TAG, "citationCallback: close notice is not send");
        this.isSendClosedNotice = true;
        return null;
    L9:
        return new Pair(r101, r100);
    }

    public final void citationCallback(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r101, "id");
        Pair<String, String> r102 = buildCallbackEvent(r100, r101);
        if (r102 != null) goto L5;
        return;
    L5:
        Log.i(TAG, "citationCallback: " + r101 + ' ' + r100);
        this.callbackEvent.setValue(r102);
    }

    public static /* synthetic */ Pair buildCallbackEvent$default(DocAICitationViewModel r100, String r101, String r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L11;
        ShowCitationData r105 = r100.citationData.getValue();
        if (r105 == null) goto L7;
        r102 = r105.getId();
    L8:
        if (r102 != null) goto L11;
        r102 = "";
        goto L11
    L7:
        r102 = null;
    L11:
        return r100.buildCallbackEvent(r101, r102);
    }

    public static /* synthetic */ void citationCallback$default(DocAICitationViewModel r100, String r101, String r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L10;
        ShowCitationData r105 = r100.citationData.getValue();
        if (r105 == null) goto L7;
        r102 = r105.getId();
    L8:
        if (r102 != null) goto L10;
        r102 = "";
        goto L10
    L7:
        r102 = null;
    L10:
        r100.citationCallback(r101, r102);
    }
}
