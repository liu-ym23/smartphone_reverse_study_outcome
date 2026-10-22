package com.larus.chat.gallery.impl.preview.input;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.bmhome.chat.api.q0;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.chat.gallery.api.PreviewMediaType;
import com.larus.chat.gallery.api.PreviewSelectionLimit;
import com.larus.chat.gallery.impl.preview.data.SourceType;
import com.larus.chat.gallery.impl.preview.provider.o0;
import com.larus.chat.gallery.impl.preview.provider.p0;
import com.larus.gallery.api.GalleryType;
import com.larus.nova.R;
import com.larus.platform.model.action.SuggestedAction;
import com.larus.platform.model.action.SuggestedActionScene;
import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes26.dex */
public final class PreviewInputCallback implements com.larus.chat.gallery.providers.input.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e0 f324333a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.larus.gallery.api.w f324334b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0<xy8.d> f324335c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function0<FragmentActivity> f324336d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final PreviewCameraParamProvider f324337e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final com.larus.chat.gallery.api.q f324338f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Function0<Boolean> f324339g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Function0<Unit> f324340h;

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f324341a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f324342b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ int[] f324343c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final /* synthetic */ int[] f324344d = null;

        static {
            int[] r100 = new int[SourceType.values().length];
            r100[SourceType.USER_SEND.ordinal()] = 1;     // Catch: NoSuchFieldError -> L22
        L39:
            r100[SourceType.BOT_RESP.ordinal()] = 2;     // Catch: NoSuchFieldError -> L23
        L57:
            r100[SourceType.CREATION_CARD.ordinal()] = 3;     // Catch: NoSuchFieldError -> L24
        L43:
            r100[SourceType.ALBUM.ordinal()] = 4;     // Catch: NoSuchFieldError -> L25
        L45:
            r100[SourceType.ATTACHMENT.ordinal()] = 5;     // Catch: NoSuchFieldError -> L26
        L35:
            r100[SourceType.CAMERA_RESULT.ordinal()] = 6;     // Catch: NoSuchFieldError -> L27
        L47:
            r100[SourceType.CLOUD_DRIVE.ordinal()] = 7;     // Catch: NoSuchFieldError -> L28
        L49:
            r100[SourceType.CREATION_RECORD.ordinal()] = 8;     // Catch: NoSuchFieldError -> L29
        L12:
            f324341a = r100;
            int[] r101 = new int[SuggestedActionScene.values().length];
            r101[SuggestedActionScene.AttachmentAreaSingleImg.ordinal()] = 1;     // Catch: NoSuchFieldError -> L30
        L37:
            r101[SuggestedActionScene.AttachmentAreaMultiImg.ordinal()] = 2;     // Catch: NoSuchFieldError -> L31
        L15:
            f324342b = r101;
            int[] r102 = new int[PreviewSelectionLimit.MediaScope.values().length];
            r102[PreviewSelectionLimit.MediaScope.IMAGE_ONLY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L32
        L55:
            r102[PreviewSelectionLimit.MediaScope.IMAGE_AND_VIDEO.ordinal()] = 2;     // Catch: NoSuchFieldError -> L33
        L18:
            f324343c = r102;
            int[] r103 = new int[GalleryType.values().length];
            r103[GalleryType.Video.ordinal()] = 1;     // Catch: NoSuchFieldError -> L34
        L20:
            f324344d = r103;
        }
    }

    static {
    }

    @Override // com.larus.chat.gallery.providers.input.b
    public final boolean d() {
        return true;
    }

    @Override // com.larus.chat.gallery.providers.input.b
    public final void c() {
        FragmentActivity r100 = this.f324336d.invoke();
        if (r100 != null) goto L6;
        FLogger.f375446a.e("PreviewInputCallback", "onCameraEntranceClick: activity is null, ignore");
        return;
    L6:
        xy8.d r101 = this.f324335c.invoke();
        if (r101 != null) goto L10;
        FLogger.f375446a.e("PreviewInputCallback", "onCameraEntranceClick: currentData is null, ignore");
        return;
    L10:
        xy8.d r102 = this.f324335c.invoke();
        boolean r103 = true;
        if (r102 == null) goto L57;
        xy8.e r104 = r102.f565438m;
        if (r104 == null) goto L17;
        String r105 = r104.f565447e;
        if (r105 == null) goto L17;
    L20:
        if (r104 == null) goto L23;
        String r106 = r104.f565445c;
        if (r106 == null) goto L23;
    L28:
        if (r102.f565426a != SourceType.USER_SEND) goto L30;
        String r107 = "user";
    L32:
        if (b.f324344d[r102.f565430e.ordinal()] != 1) goto L34;
        String r110 = "video_detail";
    L35:
        JSONObject r111 = new JSONObject();
        Iterator<Map.Entry<String, Object>> r108 = r102.f565431f.entrySet().iterator();
    L37:
        if (r108.hasNext() == false) goto L39;
        Map.Entry<String, Object> r112 = r108.next();
        r111.put(r112.getKey(), r112.getValue());
        goto L37
    L39:
        if (r105 != null) goto L41;
    L44:
        boolean r109 = true;
    L45:
        if (r109 == true) goto L47;
        r111.put("creation_task_id", r105);
    L47:
        if (r106 != null) goto L49;
    L52:
        boolean r113 = true;
    L53:
        if (r113 == true) goto L55;
        r111.put(MusicAppletPage.KEY_MESSAGE_ID, r106);
    L55:
        r111.put("user_type", r107);
        r111.put("current_page", r110);
        r111.put("camera_type", "general");
        com.larus.platform.service.o.f365780a.reportEvent("click_camera", r111);
        goto L57
    L49:
        if (r106.length() == 0) goto L52;
        r113 = false;
        goto L53
    L41:
        if (r105.length() == 0) goto L44;
        r109 = false;
        goto L45
    L34:
        r110 = "picture_detail";
        goto L35
    L30:
        r107 = "bot";
    L23:
        xy8.f r114 = r102.f565437l;
        if (r114 == null) goto L26;
        r106 = r114.f565454a;
        goto L28
    L26:
        r106 = null;
    L17:
        if (r104 == null) goto L19;
        r105 = r104.f565443a;
        goto L20
    L19:
        r105 = null;
    L57:
        if (uy8.b.b("album") == false) goto L76;
        com.larus.chat.gallery.api.q r115 = this.f324338f;
        if (r115 == null) goto L72;
        PreviewSelectionLimit r116 = r115.r(PreviewMediaType.IMAGE);
        if (r116 == null) goto L72;
        int r117 = b.f324343c[r116.f324115b.ordinal()];
        if (r117 != 1) goto L66;
        int r118 = R.string.larus_multi_photo_uploading_toast_maximum_number;
    L71:
        t19.s r119 = t19.s.f544207a;
        String r120 = r100.getString(r118, new Object[]{String.valueOf(r116.f324114a)});
        r119.getClass();
        t19.s.t(r100, r120);
        boolean r121 = false;
    L73:
        if (r121 == true) goto L76;
        return;
    L66:
        if (r117 != 2) goto L69;
        r118 = R.string.larus_videoSum_select_errToast_limit;
        goto L71
    L69:
        throw new NoWhenBranchMatchedException();
    L72:
        r121 = true;
    L76:
        if (this.f324339g.invoke().booleanValue() == true) goto L79;
        FLogger.f375446a.e("PreviewInputCallback", "onCameraEntranceClick: pending result unavailable");
        return;
    L79:
        com.larus.chat.gallery.impl.preview.p r122 = this.f324337e.f324315d;
        if ((r122 instanceof com.larus.chat.gallery.impl.preview.p.a) == false) goto L82;
        com.larus.chat.gallery.impl.preview.p.a r123 = (com.larus.chat.gallery.impl.preview.p.a) r122;
    L83:
        if (r123 == null) goto L89;
        q0 r124 = r123.f324418e;
        if (r124 == null) goto L89;
        q0.a r125 = r124.getProvider();
        if (r125 == null) goto L89;
        zb8.e r126 = r125.P8();
    L90:
        if (r126 != null) goto L93;
        r103 = false;
    L93:
        if (r103 == true) goto L95;
        this.f324333a.c(false);
    L95:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r100), null, null, new PreviewInputCallback$onCameraEntranceClick$1(this, r100, r101, null), 3, null);
        return;
    L89:
        r126 = null;
        goto L90
    L82:
        r123 = null;
        goto L83
    }

    @Override // com.larus.chat.gallery.providers.input.b
    public final void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "text");
        PreviewCameraParamProvider r101 = this.f324337e;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "text");
        r101.f324325n = r100;
        com.larus.chat.gallery.api.q r102 = this.f324338f;
        if (r102 == null) goto L6;
        r102.s(r100);
        return;
    }

    @Override // com.larus.chat.gallery.providers.input.b
    public final void b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "text");
        f(r100, null);
    }

    @Override // com.larus.chat.gallery.providers.input.b
    public final void e(SuggestedAction r210, SuggestedActionScene r211) {
        Intrinsics.checkNotNullParameter(r210, "action");
        Intrinsics.checkNotNullParameter(r211, "scene");
        if (this.f324333a.d() == false) goto L5;
        return;
    L5:
        xy8.d r100 = this.f324335c.invoke();
        if (r100 != null) goto L9;
        FLogger.f375446a.e("PreviewInputCallback", "onSuggestedActionClick: currentData is null, ignore");
        return;
    L9:
        Map<String, String> r110 = r210.getEventExtra();
        if (r110 == null) goto L13;
        Map r111 = MapsKt.toMutableMap(r110);
        if (r111 == null) goto L13;
    L14:
        int r112 = b.f324342b[r211.ordinal()];
        if (r112 != 1) goto L17;
    L19:
        r111.put("sug_scene", "attachment_suggest");
    L20:
        Unit r113 = Unit.INSTANCE;
        String r114 = null;
        if ((!r111.isEmpty()) == false) goto L23;
        Map r115 = r111;
    L24:
        SuggestedAction r101 = SuggestedAction.copy$default(r210, null, 0, 0, null, false, null, null, null, null, r115, null, null, 3583, null);
        e0 r102 = this.f324333a;
        Map<String, String> r103 = r101.getEventExtra();
        if (r103 == null) goto L28;
        r114 = r103.get("sug_scene");
    L28:
        if (r102.b(r101, r100, r114) == false) goto L32;
        com.larus.gallery.api.w r104 = this.f324334b;
        if (r104 == null) goto L34;
        r104.Rf(com.larus.gallery.api.p.c.f343878a);
        return;
    L34:
        return;
    L32:
        FLogger.f375446a.e("PreviewInputCallback", "onSuggestedActionClick: handoff failed, scene=" + r211);
        return;
    L23:
        r115 = null;
        goto L24
    L17:
        if (r112 == 2) goto L19;
    L13:
        r111 = new LinkedHashMap();
        goto L14
    }

    public final void f(String r100, zy8.s r101) {
        Intrinsics.checkNotNullParameter(r100, "text");
        if (this.f324333a.d() == false) goto L5;
        return;
    L5:
        xy8.d r102 = this.f324335c.invoke();
        if (r102 != null) goto L9;
        FLogger.f375446a.e("PreviewInputCallback", "onSendText: currentData is null, ignore");
        return;
    L9:
        FLogger.f375446a.i("PreviewInputCallback", "onSendText, sourceType=" + r102.f565426a);
        switch(b.f324341a[r102.f565426a.ordinal()]) {
            case 1: goto L14;
            case 2: goto L14;
            case 3: goto L14;
            case 4: goto L14;
            case 5: goto L14;
            case 6: goto L14;
            case 7: goto L14;
            case 8: goto L13;
            default: goto L12;
        };
    L13:
        boolean r103 = this.f324333a.h(r100, r102);
    L15:
        if (r103 == false) goto L20;
        com.larus.gallery.api.w r104 = this.f324334b;
        if (r104 == null) goto L21;
        r104.Rf(com.larus.gallery.api.p.c.f343878a);
        return;
    L21:
        return;
    L20:
        return;
    L14:
        r103 = this.f324333a.e(r100, r102, r101);
        goto L15
    L12:
        throw new NoWhenBranchMatchedException();
    }

    public PreviewInputCallback(e0 r100, com.larus.gallery.api.w r101, o0 r102, p0 r103, PreviewCameraParamProvider r104, com.larus.chat.gallery.api.q r105, com.larus.chat.gallery.impl.preview.provider.q0 r106, Function0 r107) {
        Intrinsics.checkNotNullParameter(r100, "sendStrategy");
        Intrinsics.checkNotNullParameter(r102, "currentDataProvider");
        Intrinsics.checkNotNullParameter(r103, "activityProvider");
        Intrinsics.checkNotNullParameter(r104, "paramProvider");
        Intrinsics.checkNotNullParameter(r106, "onBeforeCameraLaunch");
        Intrinsics.checkNotNullParameter(r107, "onCameraLaunchFailed");
        this.f324333a = r100;
        this.f324334b = r101;
        this.f324335c = r102;
        this.f324336d = r103;
        this.f324337e = r104;
        this.f324338f = r105;
        this.f324339g = r106;
        this.f324340h = r107;
    }
}
