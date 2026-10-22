package com.obric.assistant.actionbar.service;

import android.view.View;
import android.widget.TextView;
import com.larus.audio.audiov3.task.asr.AsrLifeState;
import com.larus.bmhome.actionbar.model.z0;
import com.larus.im.bean.message.ReferenceInfo;
import com.obric.assistant.spi.actionbar.IObricActionBarTrackService;
import com.obric.trace.ObricActionBarTrackType;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import qha.e;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\t\u0010\u0004\u001a\u00020\u0005H\u0096\u0001J\t\u0010\u0006\u001a\u00020\u0005H\u0096\u0001J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0096\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005H\u0096\u0001J\u0011\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000eH\u0096\u0001J\u0011\u0010\u000f\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u000eH\u0096\u0001JF\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u000eH\u0096\u0001¢\u0006\u0002\u0010\u001bJ\u001c\u0010\u001c\u001a\u00020\u00122\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00050\u001eH\u0096\u0001¢\u0006\u0002\u0010\u001fJ\u0019\u0010\u001c\u001a\u00020\u00122\u000e\u0010 \u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010!H\u0096\u0001J\u0011\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0010H\u0096\u0001J\u001f\u0010\u001c\u001a\u00020\u00122\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00160!2\u0006\u0010#\u001a\u00020\u000eH\u0096\u0001J\u001b\u0010$\u001a\u00020\u00122\u0006\u0010%\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0005H\u0096\u0001J)\u0010&\u001a\u00020\u00122\u0006\u0010'\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0019H\u0096\u0001J!\u0010(\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0019H\u0096\u0001J!\u0010)\u001a\u00020\u00122\u0006\u0010*\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0019H\u0096\u0001J\u0019\u0010+\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0019H\u0096\u0001J!\u0010,\u001a\u00020\u00122\u0006\u0010%\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0019H\u0096\u0001J2\u0010-\u001a\u00020\u00122\u0006\u0010.\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u00010\u000e2\b\u00101\u001a\u0004\u0018\u00010\u00052\u0006\u00102\u001a\u000203H\u0096\u0001¢\u0006\u0002\u00104J1\u00105\u001a\u00020\u00122\u0006\u00106\u001a\u0002072\b\u00108\u001a\u0004\u0018\u00010\u00052\u0014\u00109\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010:H\u0096\u0001J\u0011\u0010;\u001a\u00020\u00122\u0006\u0010<\u001a\u00020\nH\u0096\u0001J\u001b\u0010=\u001a\u00020\u00122\b\u00108\u001a\u0004\u0018\u00010\u00052\u0006\u0010>\u001a\u00020?H\u0096\u0001¨\u0006@"}, d2 = {"Lcom/obric/assistant/actionbar/service/ObricActionBarTrackServiceExtDelegate;", "Lcom/obric/assistant/actionbar/service/IObricActionBarTrackServiceExt;", "<init>", "()V", "getCurrentModelLevel", "", "getObricMockClickActionBarKey", "getReferenceInfo", "Lcom/larus/im/bean/message/ReferenceInfo;", "isAssistantActionBar", "", "actionBarKey", "mapToActionBarV2Option", "itemId", "", "mapToObricActionBarTrackType", "Lcom/obric/trace/ObricActionBarTrackType;", "mobChatActionBarClick", "", "clickV2Option", "traceType", "customActionBarItem", "Lcom/larus/bmhome/actionbar/model/CustomActionBarItem;", "botId", "conversationId", "", "clickPosition", "(Ljava/lang/String;Lcom/obric/trace/ObricActionBarTrackType;Lcom/larus/bmhome/actionbar/model/CustomActionBarItem;Ljava/lang/String;JLjava/lang/Integer;)V", "mobChatActionBarShow", "actionBarKeyList", "", "([Ljava/lang/String;)V", "actionBarList", "", "Lcom/obric/assistant/view/actionbar/custom/ObricBaseSegment;", "position", "mobObricActionBarBoardClick", "currentActionBar", "mobObricActionBarBoardLeave", "leaveMethod", "mobObricActionBarBoardShow", "mobObricActionBarLv3BoardClick", "clickV3Option", "mobObricActionBarLv3BoardShow", "mobObricActionPanelShow", "onObricActionBarInstructionShow", "tag", "Landroid/widget/TextView;", "status", "displayText", "itemView", "Landroid/view/View;", "(Landroid/widget/TextView;Ljava/lang/Integer;Ljava/lang/String;Landroid/view/View;)V", "onObricVoiceAuthenAsrUpdate", "lifeState", "Lcom/larus/audio/audiov3/task/asr/AsrLifeState;", DBDefinition.TASK_ID, "extraMap", "", "setIsClickModeChangeButton", "isClickModeChangeButton", "setObricVoiceAuthenParams", "json", "Lorg/json/JSONObject;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricActionBarTrackServiceExtDelegate implements IObricActionBarTrackServiceExt {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ObricActionBarTrackServiceExtDelegate f385252b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IObricActionBarTrackServiceExt f385253a;

    static {
        f385252b = new ObricActionBarTrackServiceExtDelegate();
    }

    @Override // com.obric.assistant.actionbar.service.IObricActionBarTrackServiceExt
    public final boolean a(String r100) {
        return this.f385253a.a(r100);
    }

    @Override // com.obric.assistant.actionbar.service.IObricActionBarTrackServiceExt
    public final void b(List<? extends e> r100) {
        this.f385253a.b(r100);
    }

    @Override // com.obric.assistant.actionbar.service.IObricActionBarTrackServiceExt
    public final String c(int r100) {
        return this.f385253a.c(r100);
    }

    @Override // com.obric.assistant.actionbar.service.IObricActionBarTrackServiceExt
    public final void d(String r100) {
        Intrinsics.checkNotNullParameter("obric_omni", "currentActionBar");
        this.f385253a.d(r100);
    }

    @Override // com.obric.assistant.actionbar.service.IObricActionBarTrackServiceExt
    public final void e() {
        this.f385253a.e();
    }

    @Override // com.obric.assistant.actionbar.service.IObricActionBarTrackServiceExt
    public final void f(String r110, ObricActionBarTrackType r111, z0 r112, String r113, long r114, Integer r115) {
        Intrinsics.checkNotNullParameter(r112, "customActionBarItem");
        this.f385253a.f(r110, r111, r112, r113, r114, r115);
    }

    @Override // com.obric.assistant.actionbar.service.IObricActionBarTrackServiceExt
    public final void g(z0 r100, String r101, long r102) {
        Intrinsics.checkNotNullParameter(r100, "customActionBarItem");
        Intrinsics.checkNotNullParameter(r101, "botId");
        this.f385253a.g(r100, r101, r102);
    }

    @Override // com.obric.assistant.spi.actionbar.IObricActionBarTrackService
    public final String h() {
        return this.f385253a.h();
    }

    @Override // com.obric.assistant.actionbar.service.IObricActionBarTrackServiceExt
    public final void i(String r100, long r101) {
        Intrinsics.checkNotNullParameter("oauto_scheduled", "clickV3Option");
        Intrinsics.checkNotNullParameter(r100, "botId");
        this.f385253a.i(r100, r101);
    }

    @Override // com.obric.assistant.actionbar.service.IObricActionBarTrackServiceExt
    public final void j(List<z0> r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "actionBarList");
        this.f385253a.j(r100, r101);
    }

    @Override // com.obric.assistant.spi.actionbar.IObricActionBarTrackService
    public final void k(TextView r100, Integer r101, String r102, View r103) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r103, "itemView");
        this.f385253a.k(r100, r101, r102, r103);
    }

    @Override // com.obric.assistant.actionbar.service.IObricActionBarTrackServiceExt
    public final void l(String r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "botId");
        this.f385253a.l(r100, r101);
    }

    @Override // com.obric.assistant.actionbar.service.IObricActionBarTrackServiceExt
    public final void m(String[] r100) {
        Intrinsics.checkNotNullParameter(r100, "actionBarKeyList");
        this.f385253a.m(r100);
    }

    @Override // com.obric.assistant.spi.actionbar.IObricActionBarTrackService
    public final void n(String r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r101, "json");
        this.f385253a.n(r100, r101);
    }

    @Override // com.obric.assistant.actionbar.service.IObricActionBarTrackServiceExt
    public final void o(ObricActionBarTrackType r100) {
        Intrinsics.checkNotNullParameter(r100, "traceType");
        this.f385253a.o(r100);
    }

    @Override // com.obric.assistant.spi.actionbar.IObricActionBarTrackService
    public final String p() {
        return this.f385253a.p();
    }

    @Override // com.obric.assistant.actionbar.service.IObricActionBarTrackServiceExt
    public final void q(String r100, z0 r101, String r110, long r111) {
        Intrinsics.checkNotNullParameter(r100, "leaveMethod");
        Intrinsics.checkNotNullParameter(r101, "customActionBarItem");
        Intrinsics.checkNotNullParameter(r110, "botId");
        this.f385253a.q(r100, r101, r110, r111);
    }

    @Override // com.obric.assistant.spi.actionbar.IObricActionBarTrackService
    public final ReferenceInfo r() {
        return this.f385253a.r();
    }

    @Override // com.obric.assistant.actionbar.service.IObricActionBarTrackServiceExt
    public final void s(String r100, String r101, long r102) {
        Intrinsics.checkNotNullParameter(r100, "currentActionBar");
        Intrinsics.checkNotNullParameter(r101, "botId");
        this.f385253a.s(r100, r101, r102);
    }

    @Override // com.obric.assistant.spi.actionbar.IObricActionBarTrackService
    public final void t(AsrLifeState r100, String r101, Map<String, String> r102) {
        Intrinsics.checkNotNullParameter(r100, "lifeState");
        this.f385253a.t(r100, r101, r102);
    }

    @Override // com.obric.assistant.actionbar.service.IObricActionBarTrackServiceExt
    public final ObricActionBarTrackType u(int r100) {
        return this.f385253a.u(r100);
    }

    private ObricActionBarTrackServiceExtDelegate() {
        Object r100 = ServiceManager.get().getService(IObricActionBarTrackService.class);
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.obric.assistant.actionbar.service.IObricActionBarTrackServiceExt");
        this.f385253a = (IObricActionBarTrackServiceExt) r100;
    }
}
