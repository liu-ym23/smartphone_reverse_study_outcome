package com.larus.uaigc.helper;

import android.graphics.BitmapFactory;
import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.bmhome.chat.bean.ProcessFileResultCode;
import com.larus.bmhome.resource.access.ResourceMediaType;
import com.larus.bmhome.resource.access.ResourceNodeHandler;
import com.larus.bmhome.utils.ImFileUtil;
import com.larus.im.bean.message.Image;
import com.larus.im.bean.message.ImageObj;
import com.larus.im.bean.message.UplinkEntityContent;
import com.larus.im.bean.message.UplinkFileEntity;
import com.larus.minor.model.MinorConfigItems;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\rH\u0096@¢\u0006\u0002\u0010\u0010R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/larus/uaigc/helper/CreationImagePreprocessHandler;", "Lcom/larus/bmhome/resource/access/ResourceNodeHandler;", "<init>", "()V", "key", "", "getKey", "()Ljava/lang/String;", "nodeKey", "getNodeKey", "supports", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Lcom/larus/bmhome/resource/access/ResourceContext;", "execute", "Lcom/larus/bmhome/resource/access/NodeResult;", "(Lcom/larus/bmhome/resource/access/ResourceContext;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CreationImagePreprocessHandler implements ResourceNodeHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f372937a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f372938b;

    @Override // com.larus.bmhome.resource.access.ResourceNodeHandler
    public final void getPriority() {
    }

    public CreationImagePreprocessHandler() {
        this.f372937a = "creation_image_preprocess";
        this.f372938b = "preprocess";
    }

    @Override // com.larus.bmhome.resource.access.ResourceNodeHandler
    public final String a() {
        return this.f372938b;
    }

    @Override // com.larus.bmhome.resource.access.ResourceNodeHandler
    public final String getKey() {
        return this.f372937a;
    }

    @Override // com.larus.bmhome.resource.access.ResourceNodeHandler
    public final boolean b(com.larus.bmhome.resource.access.h0 r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (a0.b(r100) == true) goto L6;
        return false;
    L6:
        if (r100.f313671a.f313764c == ResourceMediaType.IMAGE) goto L8;
        return false;
    L8:
        com.larus.bmhome.resource.access.j0 r101 = r100.f313673c;
        if ((r101 instanceof com.larus.bmhome.resource.access.j0.a) == false) goto L12;
        return true;
    L12:
        if ((r101 instanceof com.larus.bmhome.resource.access.j0.b) == false) goto L15;
        return a0.a(r100, "enable_preprocess", new j());
    L15:
        if ((r101 instanceof com.larus.bmhome.resource.access.j0.c) == false) goto L17;
        return false;
    L17:
        if ((r101 instanceof com.larus.bmhome.resource.access.j0.d) == false) goto L20;
        return false;
    L20:
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.larus.bmhome.resource.access.ResourceNodeHandler
    public final Object c(com.larus.bmhome.resource.access.h0 r410, Continuation<? super com.larus.bmhome.resource.access.g> r510) {
        com.larus.bmhome.resource.access.h0 r100 = r410;
        if ((r510 instanceof CreationImagePreprocessHandler$execute$1) == false) goto L7;
        CreationImagePreprocessHandler$execute$1 r101 = (CreationImagePreprocessHandler$execute$1) r510;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        if (r105 == 0) goto L14;
        if (r105 != 1) goto L13;
        com.larus.bmhome.resource.access.j0 r106 = (com.larus.bmhome.resource.access.j0) r101.L$1;
        com.larus.bmhome.resource.access.h0 r107 = (com.larus.bmhome.resource.access.h0) r101.L$0;
        ResultKt.throwOnFailure(r103);
        com.larus.bmhome.resource.access.j0 r108 = r106;
        r100 = r107;
        Object r109 = r103;
    L26:
        ic8.n0 r110 = (ic8.n0) r109;
        ic8.m0 r111 = r110.f489243a;
        ProcessFileResultCode r112 = r110.f489244b;
        if (r112 != null) goto L29;
    L31:
        boolean r113 = false;
    L32:
        if (r113 == false) goto L156;
        if (r111 == null) goto L35;
        String r114 = r111.f489227e;
    L36:
        if (r114 != null) goto L38;
    L41:
        boolean r115 = true;
    L42:
        if (r115 == true) goto L156;
        if (r111 == null) goto L45;
        String r116 = r111.f489227e;
    L46:
        String r117 = "";
        if (r116 != null) goto L49;
        r116 = "";
    L49:
        if (r111 == null) goto L54;
        String r118 = r111.f489223a;
        if (r118 == null) goto L54;
        String r119 = r118;
    L55:
        int r120 = g.f373020a;
        if (r111 == null) goto L58;
        String r121 = r111.f489223a;
    L59:
        Boolean r122 = Boxing.boxBoolean(g.b(r121));
        if (r111 == null) goto L67;
        Long r123 = Boxing.boxLong(r111.f489225c);
        if (r123.longValue() < 0) goto L64;
        boolean r124 = true;
    L65:
        if (r124 == false) goto L67;
        Long r125 = r123;
    L68:
        if (r111 == null) goto L70;
        mr9.c r126 = r111.f489234l;
    L71:
        com.larus.bmhome.resource.access.j0.b r127 = new com.larus.bmhome.resource.access.j0.b(r116, r119, r122, r125, r126);
        if (r111 == null) goto L74;
        mr9.c r210 = r111.f489234l;
    L75:
        if (r111 == null) goto L82;
        Long r128 = Boxing.boxLong(r111.f489225c);
        if (r128.longValue() < 0) goto L79;
        boolean r129 = true;
    L80:
        if (r129 == false) goto L82;
        Long r211 = r128;
    L83:
        mr9.h r130 = r100.f313676f;
        String r131 = r100.f313671a.f313765d.f313654a;
        Set<String> r132 = i.f373022a;
        UplinkFileEntity r133 = r130.f514996c;
        if (r133 == null) goto L91;
        UplinkEntityContent r134 = r133.getUplinkEntityContent();
        if (r134 == null) goto L91;
        Image r135 = r134.getUplinkImageInfo();
        if (r135 == null) goto L91;
        PolarisFileWrapper r136 = new PolarisFileWrapper(r116);
        BitmapFactory.Options r137 = new BitmapFactory.Options();
        r137.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(r116, r137);
        int r138 = r137.outWidth;
        if (r138 > 0) goto L95;
    L97:
        Pair r139 = null;
    L98:
        if (r139 == null) goto L104;
        int r140 = ((Number) r139.component1()).intValue();
        int r141 = ((Number) r139.component2()).intValue();
        ImageObj r142 = r135.imageOri;
        if (r142 != null) goto L102;
        r142 = new ImageObj(null, 0, 0, null, null, 31, null);
    L102:
        ImageObj r143 = ImageObj.copy$default(r142, null, r140, r141, null, null, 25, null);
        if (r143 == null) goto L104;
    L105:
        if (r111 == null) goto L108;
        String r144 = r111.f489228f;
        if (r144 == null) goto L108;
    L109:
        String r145 = r135.identifier;
        if (r145 != null) goto L112;
        String r146 = r131;
    L113:
        Map<String, String> r147 = r135.ext;
        if (r147 != null) goto L116;
        r147 = MapsKt.emptyMap();
    L116:
        if (r111 == null) goto L120;
        PolarisFileWrapper r148 = r136;
        if (r111.f489231i != true) goto L121;
        boolean r149 = true;
    L122:
        if (r149 == false) goto L124;
        String r150 = "1";
    L125:
        Map r151 = MapsKt.plus(r147, MapsKt.mapOf(TuplesKt.to("is_marked", r150)));
        PolarisFileWrapper r152 = r148;
        Image r153 = Image.copy$default(r135, null, r144, null, r143, null, r116, r146, r151, null, null, null, null, null, null, 16149, null);
        Uri r411 = Uri.fromFile(r152);
        mr9.h r212 = mr9.h.a(r130, UplinkFileEntity.copy$default(r133, null, UplinkEntityContent.copy$default(r134, null, r153, 1, null), null, null, null, null, null, null, null, false, r411, null, null, null, 15357, null));
    L126:
        String r154 = StringsKt.substringAfterLast(r116, '.', "");
        if (r154.length() <= 0) goto L129;
        boolean r155 = true;
    L130:
        if (r155 == true) goto L133;
        r154 = null;
    L133:
        if (r154 != null) goto L135;
        String r213 = r100.f313677g;
    L136:
        Pair[] r156 = new Pair[3];
        ProcessFileResultCode r157 = r110.f489244b;
        if (r157 == null) goto L139;
        String r158 = r157.getValue();
    L140:
        if (r158 != null) goto L142;
        r158 = "";
    L142:
        r156[0] = TuplesKt.to("preprocess_result", r158);
        if (r111 == null) goto L145;
        String r159 = Boxing.boxLong(r111.f489225c).toString();
    L146:
        if (r159 != null) goto L148;
        r159 = "";
    L148:
        r156[1] = TuplesKt.to("preprocess_file_size", r159);
        if (r111 == null) goto L151;
        String r160 = r111.f489226d;
    L152:
        if (r160 == null) goto L155;
        r117 = r160;
    L155:
        r156[2] = TuplesKt.to("preprocess_file_type", r117);
        mr9.c r214 = r210;
        Long r215 = r211;
        return new com.larus.bmhome.resource.access.g.a(new com.larus.bmhome.resource.access.i0(r127, r214, r215, r212, r213, null, MapsKt.mapOf(r156), 32));
    L151:
        r160 = null;
        goto L152
    L145:
        r159 = null;
        goto L146
    L139:
        r158 = null;
        goto L140
    L135:
        r213 = r154;
        goto L136
    L129:
        r155 = false;
        goto L130
    L124:
        r150 = "0";
    L121:
        r149 = false;
        goto L122
    L120:
        r148 = r136;
        goto L121
    L112:
        r146 = r145;
    L108:
        ImFileUtil.f314899a.getClass();
        r144 = ImFileUtil.g(r136);
    L104:
        r143 = r135.imageOri;
        goto L105
    L95:
        if (r137.outHeight <= 0) goto L97;
        r139 = TuplesKt.to(Integer.valueOf(r138), Integer.valueOf(r137.outHeight));
    L91:
        r212 = r130;
        goto L126
    L79:
        r129 = false;
    L82:
        r211 = null;
        goto L83
    L74:
        r210 = null;
        goto L75
    L70:
        r126 = null;
        goto L71
    L64:
        r124 = false;
    L67:
        r125 = null;
        goto L68
    L58:
        r121 = null;
    L54:
        r119 = r108.a();
        goto L55
    L45:
        r116 = null;
        goto L46
    L38:
        if (r114.length() == 0) goto L41;
        r115 = false;
        goto L42
    L35:
        r114 = null;
    L156:
        String r161 = this.f372938b;
        ProcessFileResultCode r162 = r110.f489244b;
        if (r162 == null) goto L160;
        String r163 = r162.getValue();
        if (r163 == null) goto L160;
    L162:
        return new com.larus.bmhome.resource.access.g.b(new com.larus.bmhome.resource.access.r(r161, r163, "creation image preprocess failed", null));
    L160:
        r163 = ProcessFileResultCode.PREPARE_OPEN_FILE_ERROR.getValue();
        goto L162
    L29:
        if (r112.isSuccess() != true) goto L31;
        r113 = true;
        goto L32
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r103);
        r108 = r100.f313673c;
        if ((r108 instanceof com.larus.bmhome.resource.access.j0.a) == false) goto L18;
        Uri r164 = UriProtector.parse(((com.larus.bmhome.resource.access.j0.a) r108).f313689b);
    L20:
        String r165 = r100.f313671a.f313765d.f313657d;
        if (r165 != null) goto L23;
        r165 = MinorConfigItems.AI_CREATION;
    L23:
        CreationImageUploadPolicy r166 = CreationImageUploadPolicy.f372948a;
        Intrinsics.checkNotNull(r164);
        String r167 = r410.b().get("preprocess_sub_scene");
        r101.L$0 = r100;
        r101.L$1 = r108;
        r101.label = 1;
        r109 = r166.a(r164, r165, r167, r101);
        if (r109 != r104) goto L26;
        return r104;
    L18:
        if ((r108 instanceof com.larus.bmhome.resource.access.j0.b) == false) goto L164;
        r164 = Uri.fromFile(new PolarisFileWrapper(((com.larus.bmhome.resource.access.j0.b) r108).f313690b));
        goto L20
    L164:
        if ((r108 instanceof com.larus.bmhome.resource.access.j0.c) == true) goto L171;
        if ((r108 instanceof com.larus.bmhome.resource.access.j0.d) == true) goto L171;
        throw new NoWhenBranchMatchedException();
    L171:
        return com.larus.bmhome.resource.access.g.e.f313653a;
    L7:
        r101 = new CreationImagePreprocessHandler$execute$1(this, r510);
        goto L8
    }
}
