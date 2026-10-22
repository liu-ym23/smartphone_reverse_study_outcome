package com.larus.bmhome.instruction;

import com.google.gson.Gson;
import com.larus.bmhome.instruction.handler.InstructionHandlerType;
import com.larus.bmhome.instruction.handler.PromptImageToVideoHandler;
import com.larus.bmhome.instruction.helper.AiBeautifyPickPhotoHelper;
import com.larus.bmhome.view.actionbar.custom.w2;
import com.larus.common.apphost.AppHost;
import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import com.larus.utils.logger.FLogger;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class p implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ComponentFeature f312193a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Gson f312194b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.larus.bmhome.instruction.handler.l f312195c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public com.larus.bmhome.instruction.handler.n f312196d;

    public static final class a {
    }

    static {
    }

    @Override // com.larus.bmhome.instruction.f
    public final void onAttach() {
        this.f312195c = new com.larus.bmhome.instruction.handler.l(s1a.a.c(this.f312193a), this);
    }

    public p(InstructionLogicComponent r100) {
        Intrinsics.checkNotNullParameter(r100, "component");
        this.f312193a = r100;
        this.f312194b = new Gson();
    }

    @Override // com.larus.bmhome.instruction.f
    public final void a(com.larus.bmhome.instruction.handler.n r100) {
        Intrinsics.checkNotNullParameter(r100, "depend");
        this.f312196d = r100;
    }

    @Override // com.larus.bmhome.instruction.f
    public final void b(n r100) {
        Intrinsics.checkNotNullParameter(r100, "inputData");
        com.larus.bmhome.instruction.handler.l r101 = this.f312195c;
        if (r101 == null) goto L68;
        Intrinsics.checkNotNullParameter(r100, "inputData");
        FLogger r102 = FLogger.f375446a;
        r102.i("ConfigInstructionActionHandler", "InstructionActionData:" + r100);
        aq8.e r103 = r100.f312184b;
        com.larus.bmhome.instruction.handler.m r104 = null;
        if (r103 == null) goto L7;
        String r105 = r103.f15940a;
    L8:
        if (r105 != null) goto L10;
    L13:
        boolean r106 = true;
    L14:
        if (r106 == false) goto L16;
        r102.e("ConfigInstructionActionHandler", "InstructionActionData inputContent is null, dangerous");
    L16:
        aq8.e r107 = r100.f312184b;
        if (r107 == null) goto L24;
        Map<String, String> r108 = r107.f15944e;
        if (r108 == null) goto L24;
        String r109 = r107.f15946g;
        if (r109 != null) goto L23;
        r109 = "";
    L23:
        r108.put("enter_method_trace", r109);
    L24:
        String r110 = r100.f312183a;
        com.larus.bmhome.instruction.handler.m r111 = (com.larus.bmhome.instruction.handler.m) ((LinkedHashMap) r101.f312107b).get(r110);
        if (r111 == null) goto L28;
    L65:
        if (r111 == null) goto L69;
        r111.a(r100);
        return;
    L69:
        return;
    L28:
        switch(r110.hashCode()) {
            case -1142053025: goto L59;
            case -1053848247: goto L55;
            case 3571588: goto L51;
            case 73725445: goto L47;
            case 81665115: goto L43;
            case 505014344: goto L39;
            case 1368705275: goto L35;
            case 1942336857: goto L31;
            default: goto L62;
        };
    L62:
        if (r104 == null) goto L64;
        boolean r112 = w1.f312246a;
        w1.c("ConfigInstructionActionHandler", "register ".concat(r110));
        r101.f312107b.put(r110, r104);
    L64:
        r111 = r104;
        goto L65
    L31:
        if (r110.equals("AVATAR") == false) goto L62;
        r104 = new com.larus.bmhome.instruction.handler.a0(r101.f312106a);
        goto L62
    L35:
        if (r110.equals("IMAGE_TO_IMAGE") == false) goto L62;
        r104 = new com.larus.bmhome.instruction.handler.w(r101.f312106a, (AiBeautifyPickPhotoHelper) r101.f312108c.getValue());
        goto L62
    L39:
        if (r110.equals(InstructionHandlerType.TEXT_TO_OPEN_CAMERA) == false) goto L62;
        r104 = new com.larus.bmhome.instruction.handler.z(r101.f312106a);
        goto L62
    L43:
        if (r110.equals("VIDEO") == false) goto L62;
        r104 = new PromptImageToVideoHandler(r101.f312106a, (AiBeautifyPickPhotoHelper) r101.f312109d.getValue());
        goto L62
    L47:
        if (r110.equals("MUSIC") == false) goto L62;
        r104 = new com.larus.bmhome.instruction.handler.c0(r101.f312106a);
        goto L62
    L51:
        if (r110.equals(InstructionHandlerType.SCHEMA_INTERCEPT) == false) goto L62;
        r104 = new com.larus.bmhome.instruction.handler.s(r101.f312106a, (AiBeautifyPickPhotoHelper) r101.f312108c.getValue());
        goto L62
    L55:
        if (r110.equals("TEXT_TO_IMAGE") == false) goto L62;
        r104 = new com.larus.bmhome.instruction.handler.b0(r101.f312106a);
        goto L62
    L59:
        if (r110.equals(InstructionHandlerType.TEXT_TO_TEXT) == false) goto L62;
        r104 = new com.larus.bmhome.instruction.handler.d0(r101.f312106a);
        goto L62
    L10:
        if (r105.length() == 0) goto L13;
        r106 = false;
        goto L14
    L7:
        r105 = null;
        goto L8
    }

    public static String c(com.larus.bmhome.actionbar.model.z0 r110, String r111, com.larus.bmhome.view.actionbar.edit.b r112) {
        Intrinsics.checkNotNullParameter(r111, "userInput");
        Intrinsics.checkNotNullParameter(r112, "dataFactory");
        com.larus.bmhome.view.actionbar.custom.e r100 = com.larus.bmhome.view.actionbar.custom.e.f315895a;     // Catch: Exception -> L9
        if (r110 == null) goto L6;
        com.larus.bmhome.actionbar.model.r r113 = r110.f295621q;     // Catch: Exception -> L9
    L7:
        return w2.a.a(r100, r111, r113, r112.b(), null, null, 0, null, 120);
    L6:
        r113 = null;
    L9:
        e = move-exception;
        FLogger.f375446a.e("InstructionComponent", "buildContent error = " + e.getMessage());
        if (AppHost.f326268a.isDebug() == true) goto L14;
        return r111;
    L14:
        throw new IllegalArgumentException("InstructionComponent, " + e.getMessage());
    }
}
