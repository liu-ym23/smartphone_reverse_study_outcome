package com.larus.avatar.impl.scan.component;

import androidx.fragment.app.Fragment;
import com.ixigua.lib.track.TrackParams;
import com.larus.avatar.impl.scan.statemachine.ScanStateType;
import com.larus.uaigc.service.IUgcAIGCService;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes23.dex */
public final class p {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Set<ScanStateType> f290963d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Fragment f290964a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d f290965b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0<Unit> f290966c;

    public static final class a {
    }

    static {
        f290963d = SetsKt.setOf(new ScanStateType[]{ScanStateType.WER_CHECKING, ScanStateType.NOT_UPLOAD});
    }

    public static void b() {
        JSONObject r100 = new JSONObject();
        r100.put("current_page", "replica_video_record_page");
        r100.put("is_has_replica", IUgcAIGCService.f373945a.v() ? 1 : 0);
        r100.put(com.bytedance.android.ec.core.event.a.KEY_MEDIA_TYPE, "text");
        r100.put("name", "confirm_giveup_replica_creation");
        TrackParams r101 = new TrackParams().merge(r100);
        by7.a r102 = new by7.a("pop_show");
        r102.f21463a.merge(r101);
        r102.b();
    }

    public static void a(String r100) {
        JSONObject r101 = new JSONObject();
        r101.put("current_page", "replica_video_record_page");
        r101.put("is_has_replica", IUgcAIGCService.f373945a.v() ? 1 : 0);
        r101.put(com.bytedance.android.ec.core.event.a.KEY_MEDIA_TYPE, "text");
        r101.put("name", "confirm_giveup_replica_creation");
        r101.put("click_type", r100);
        TrackParams r102 = new TrackParams().merge(r101);
        by7.a r103 = new by7.a("pop_click");
        r103.f21463a.merge(r102);
        r103.b();
    }

    public p(Fragment r100, d r101, Function0<Unit> r102) {
        Intrinsics.checkNotNullParameter(r102, "onConfirm");
        this.f290964a = r100;
        this.f290965b = r101;
        this.f290966c = r102;
    }
}
