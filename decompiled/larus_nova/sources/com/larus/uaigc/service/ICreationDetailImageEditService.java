package com.larus.uaigc.service;

import android.app.Activity;
import com.bytedance.common.wschannel.WsConstants;
import com.larus.bmhome.actionbar.model.z0;
import com.larus.bmhome.chat.ChatParam;
import com.larus.platform.model.creation.ResourceExt;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aJ\u0016\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&Jf\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0010\b\u0002\u0010\u000f\u001a\n\u0018\u00010\u0010j\u0004\u0018\u0001`\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\b2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\b\u0002\u0010\u0019\u001a\u00020\bH&¨\u0006\u001b"}, d2 = {"Lcom/larus/uaigc/service/ICreationDetailImageEditService;", "", "buildSingleImageRefInfo", "", "Lcom/larus/platform/model/creation/ResourceExt;", "previewUrl", "", "openDetailEditPage", "", "activity", "Landroid/app/Activity;", WsConstants.KEY_PAYLOAD, "Lcom/larus/uaigc/bean/chat/gallery/CreationDetailImageEditHelper$DetailImagePayload;", "hitPointData", "Lcom/larus/bmhome/view/actionbar/edit/creationpage/data/IInstructionHitPoint;", "actionBarItem", "Lcom/larus/bmhome/actionbar/model/CustomActionBarItem;", "Lcom/larus/bmhome/view/actionbar/custom/bean/CustomActionBarItem;", "chatParam", "Lcom/larus/bmhome/chat/ChatParam;", "selectInstructionType", "", "openNewChatPage", "trackNode", "Lcom/ixigua/lib/track/ITrackNode;", "ignoreSideBar", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface ICreationDetailImageEditService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f373910a = null;

    @Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0096\u0001J]\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u000e\u0010\u0011\u001a\n\u0018\u00010\u0012j\u0004\u0018\u0001`\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\n2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\nH\u0096\u0001¨\u0006\u001c"}, d2 = {"Lcom/larus/uaigc/service/ICreationDetailImageEditService$Companion;", "Lcom/larus/uaigc/service/ICreationDetailImageEditService;", "<init>", "()V", "buildSingleImageRefInfo", "", "Lcom/larus/platform/model/creation/ResourceExt;", "previewUrl", "", "openDetailEditPage", "", "activity", "Landroid/app/Activity;", WsConstants.KEY_PAYLOAD, "Lcom/larus/uaigc/bean/chat/gallery/CreationDetailImageEditHelper$DetailImagePayload;", "hitPointData", "Lcom/larus/bmhome/view/actionbar/edit/creationpage/data/IInstructionHitPoint;", "actionBarItem", "Lcom/larus/bmhome/actionbar/model/CustomActionBarItem;", "Lcom/larus/bmhome/view/actionbar/custom/bean/CustomActionBarItem;", "chatParam", "Lcom/larus/bmhome/chat/ChatParam;", "selectInstructionType", "", "openNewChatPage", "trackNode", "Lcom/ixigua/lib/track/ITrackNode;", "ignoreSideBar", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion implements ICreationDetailImageEditService {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ Companion f373911c = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ICreationDetailImageEditService f373912b;

        static {
            f373911c = new Companion();
        }

        @Override // com.larus.uaigc.service.ICreationDetailImageEditService
        public final List<ResourceExt> a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "previewUrl");
            return this.f373912b.a(r100);
        }

        @Override // com.larus.uaigc.service.ICreationDetailImageEditService
        public final boolean b(Activity r110, com.larus.uaigc.bean.chat.gallery.a.C4502a r111, zs8.a r112, z0 r113, ChatParam r114, int r115, boolean r116, by7.e r117, boolean r210) {
            Intrinsics.checkNotNullParameter(r110, "activity");
            Intrinsics.checkNotNullParameter(r111, WsConstants.KEY_PAYLOAD);
            Intrinsics.checkNotNullParameter(r112, "hitPointData");
            return this.f373912b.b(r110, r111, r112, r113, r114, r115, r116, r117, r210);
        }

        private Companion() {
            this.f373912b = (ICreationDetailImageEditService) ServiceManager.get().getService(ICreationDetailImageEditService.class);
        }
    }

    static {
        f373910a = Companion.f373911c;
    }

    List<ResourceExt> a(String r100);

    boolean b(Activity r100, com.larus.uaigc.bean.chat.gallery.a.C4502a r101, zs8.a r102, z0 r103, ChatParam r104, int r105, boolean r106, by7.e r107, boolean r108);
}
