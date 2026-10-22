package te0;

import android.view.View;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomBase;
import com.bytedance.android.livesdkapi.feed.ILivePreviewMultiLinkCommonWidget;
import com.bytedance.android.livesdkapi.feed.IPreviewMultiLinkEffectService;
import com.bytedance.android.scope.o;
import kotlin.jvm.internal.Intrinsics;
import yz0.j;

/* JADX INFO: loaded from: classes46.dex */
public final class b implements IPreviewMultiLinkEffectService, o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ILivePreviewMultiLinkCommonWidget.IPreviewMultiLinkEffectProvider f545552a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final j f545553b;

    public static final class a {
    }

    static {
    }

    public final IRoomBase a() {
        j r100 = this.f545553b;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getRoom();
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
        StringBuilder r100 = new StringBuilder("onStart, roomId: ");
        IRoomBase r101 = a();
        if (r101 == null) goto L5;
        String r102 = r101.getIdStr();
    L6:
        r100.append(r102);
        ALogger.i("PreviewMultiLinkEffectService", r100.toString());
        return;
    L5:
        r102 = null;
        goto L6
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
        ALogger.i("PreviewMultiLinkEffectService", "onStop");
        this.f545552a = null;
    }

    @Override // com.bytedance.android.livesdkapi.feed.IPreviewMultiLinkEffectService
    public final void removeEffectView() {
        ALogger.i("PreviewMultiLinkEffectService", "removeEffectView, provider: " + this.f545552a);
        ILivePreviewMultiLinkCommonWidget.IPreviewMultiLinkEffectProvider r100 = this.f545552a;
        if (r100 == null) goto L6;
        r100.removeEffectView();
        return;
    }

    public b(j r100) {
        Intrinsics.checkNotNullParameter(r100, "roomDataService");
        this.f545553b = r100;
    }

    @Override // com.bytedance.android.livesdkapi.feed.IPreviewMultiLinkEffectService
    public final void setFeedViewProvider(ILivePreviewMultiLinkCommonWidget.IPreviewMultiLinkEffectProvider r100) {
        StringBuilder r101 = new StringBuilder("setFeedViewProvider, roomId: ");
        IRoomBase r102 = a();
        Boolean r103 = null;
        if (r102 == null) goto L5;
        String r104 = r102.getIdStr();
    L6:
        r101.append(r104);
        r101.append(", ");
        IRoomBase r105 = a();
        if (r105 == null) goto L9;
        r103 = Boolean.valueOf(r105.isLiveTypeAudio());
    L9:
        r101.append(r103.booleanValue());
        r101.append(", provider: ");
        r101.append(r100);
        ALogger.i("PreviewMultiLinkEffectService", r101.toString());
        IRoomBase r106 = a();
        if (r106 != null) goto L12;
        return;
    L12:
        if (r106.isLiveTypeAudio() != true) goto L16;
        this.f545552a = r100;
        return;
    L16:
        return;
    L5:
        r104 = null;
        goto L6
    }

    @Override // com.bytedance.android.livesdkapi.feed.IPreviewMultiLinkEffectService
    public final void insertEffectView(View r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        StringBuilder r102 = new StringBuilder("insertEffectView, roomId: ");
        IRoomBase r103 = a();
        if (r103 == null) goto L5;
        String r104 = r103.getIdStr();
    L6:
        r102.append(r104);
        r102.append(", provider: ");
        r102.append(this.f545552a);
        ALogger.i("PreviewMultiLinkEffectService", r102.toString());
        ILivePreviewMultiLinkCommonWidget.IPreviewMultiLinkEffectProvider r105 = this.f545552a;
        if (r105 == null) goto L10;
        r105.insertEffectView(r100, r101);
        return;
    L10:
        return;
    L5:
        r104 = null;
        goto L6
    }
}
