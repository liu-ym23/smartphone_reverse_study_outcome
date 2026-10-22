package com.ss.android.lark.chat.api.service.impl;

import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.basic.v1.RequestPacket;
import com.bytedance.lark.pb.basic.v1.SyncDataStrategy;
import com.bytedance.lark.pb.im.v1.GenerateUrlPreviewEntityRequest;
import com.bytedance.lark.pb.im.v1.HideMessageUrlPreviewRequest;
import com.bytedance.lark.pb.url.v1.GetURLPreviewTemplatesByIdsRequest;
import com.bytedance.lark.pb.url.v1.GetURLPreviewTemplatesByIdsResponse;
import com.bytedance.lark.pb.url.v1.GetUrlPreviewRequest;
import com.bytedance.lark.pb.url.v1.MGetUrlPreviewRequest;
import com.bytedance.lark.pb.url.v1.UrlPreviewSourceType;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.callback.UIGetDataCallback;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larksuite.framework.utils.AndroidThrottle;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.chat.api.service.request.PullUrlPreviewRequest;
import com.ss.android.lark.chat.entity.preview.UrlPreViewEntries;
import com.ss.android.lark.chat.preview.entity.UrlPreviewResponse;
import com.ss.android.lark.export.entity.UrlCardPreviewEntity;
import com.ss.android.lark.export.entity.preview.UrlInlinePreviewEntity;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.passportc.dwarf.UserScope;
import com.ss.android.lark.sdk.SdkSender;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@UserScope
public final class PreviewService implements a2b.f {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy<PreviewService> f411558c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a2b.e f411559a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AndroidThrottle<u0> f411560b;

    public static final class a {
    }

    public static final class b<T> implements SdkSender.IParser {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b<T> f411561a = null;

        static {
            f411561a = new b();
        }

        public b() {
        }

        @Override // com.ss.android.lark.sdk.SdkSender.IParser
        public final Object parse(byte[] r100) {
            return GetURLPreviewTemplatesByIdsResponse.ADAPTER.decode(r100);
        }
    }

    public static final class c<T> implements AndroidThrottle.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PreviewService f411562a;

        public c(PreviewService r100) {
            this.f411562a = r100;
        }

        @Override // com.larksuite.framework.utils.AndroidThrottle.e
        public final void a(Collection<u0> r100) {
            Intrinsics.checkNotNullParameter(r100, "it");
            PreviewService r101 = this.f411562a;
            r101.getClass();
            if (r100.isEmpty() == true) goto L7;
            CoreThreadPool.getDefault().getFixedThreadPool().execute(new b1(r101, r100));
            return;
        }
    }

    static {
        f411558c = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, PreviewService$Companion$instance$2.INSTANCE);
    }

    @Inject
    public PreviewService(a2b.e r100) {
        Intrinsics.checkNotNullParameter(r100, "repo");
        this.f411559a = r100;
        AndroidThrottle.a r101 = new AndroidThrottle.a();
        r101.f285878b = 600;
        r101.f285879c = 2;
        r101.f285877a = CoreThreadPool.getNonblockingHandler();
        r101.f285880d = new s0();
        r101.f285881e = new c(this);
        this.f411560b = r101.a();
    }

    @Override // a2b.f
    public final void Fa(PullUrlPreviewRequest r100) {
        Intrinsics.checkNotNullParameter(r100, "request");
        Log.d("[URLPreview] PreviewService", "lazy load request " + ((String) r100.f411712b.getValue()));
        if ((!r100.f411711a.isEmpty()) == false) goto L6;
        this.f411560b.d(new u0(r100));
        return;
    }

    @Override // a2b.f
    public final void ba(final a2b.b r100, IGetDataCallback<a2b.b> r101) {
        Intrinsics.checkNotNullParameter(r100, "urlPreview");
        Intrinsics.checkNotNullParameter(r101, "uiCallback");
        String r102 = r100.f1487a;
        HideMessageUrlPreviewRequest.Builder r103 = new HideMessageUrlPreviewRequest.Builder().message_id(r102);
        a2b.e r104 = this.f411559a;
        Intrinsics.checkNotNull(r103);
        r104.c(r103, new PreviewService$deleteMessageUrlPreview$1(r100), r101);
    }

    @Override // a2b.f
    public final void getUrlInlineFromContent(String r100, IGetDataCallback<UrlInlinePreviewEntity> r101) {
        Intrinsics.checkNotNullParameter(r100, "content");
        Intrinsics.checkNotNullParameter(r101, "callback");
        Log.i("[URLPreview] GenerateUrlPreviewEntityRequest", "start, content.length:" + r100.length());
        if (r100.length() != 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L8;
        return;
    L8:
        GenerateUrlPreviewEntityRequest.Builder r103 = new GenerateUrlPreviewEntityRequest.Builder().url(r100);
        a2b.e r104 = this.f411559a;
        Intrinsics.checkNotNull(r103);
        r104.b(r103, AnonymousClass1.INSTANCE, r101);
        return;
    L5:
        r102 = false;
        goto L6
    }

    @Override // a2b.f
    public final void lc(List<String> r100, final Map<String, ? extends Map<String, UrlCardPreviewEntity>> r101) {
        Intrinsics.checkNotNullParameter(r100, "templateIdList");
        Intrinsics.checkNotNullParameter(r101, "messagePreviewMap");
        if (CollectionUtils.isEmpty(r100) == false) goto L5;
        return;
    L5:
        StringBuilder r102 = new StringBuilder("start, templateIds:");
        k6b.a r103 = k6b.a.f501977a;
        r102.append(k6b.a.d(r100));
        Log.i("[URLPreview] GetURLPreviewTemplatesByIdsRequest", r102.toString());
        GetURLPreviewTemplatesByIdsRequest.Builder r104 = new GetURLPreviewTemplatesByIdsRequest.Builder().template_ids(r100);
        SdkSender.asynSendRequestNonWrap(Command.GET_URL_PREVIEW_TEMPLATES_BY_IDS, r104, new PreviewService$getUrlTemplateList$1(this, r101), b.f411561a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [com.ss.android.lark.chat.api.service.impl.PreviewService$getUrlPreViewEntityList$2] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // a2b.f
    public final void r4(final List<String> r100, final List<String> r101, SyncDataStrategy r102, final UrlPreViewEntries.UrlPreViewSourceType r110, List<Long> r111, final UIGetDataCallback<UrlPreviewResponse> r112) {
        Intrinsics.checkNotNullParameter(r100, "sourceIdList");
        Intrinsics.checkNotNullParameter(r101, "sourceTextMD5List");
        Intrinsics.checkNotNullParameter(r102, "syncDataStrategy");
        Intrinsics.checkNotNullParameter(r110, "sourceType");
        Intrinsics.checkNotNullParameter(r112, "callback");
        if (r100.isEmpty() == false) goto L5;
        return;
    L5:
        if (r101.isEmpty() == true) goto L22;
        ArrayList r103 = new ArrayList();
        int r104 = Math.min(r101.size(), r100.size());
        int r105 = 0;
    L8:
        if (r105 >= r104) goto L15;
        GetUrlPreviewRequest.Builder r106 = new GetUrlPreviewRequest.Builder().source_id((String) ListProtector.get(r100, r105)).source_type(UrlPreviewSourceType.fromValue(r110.getValue())).source_text_md5((String) ListProtector.get(r101, r105));
        if (r111 == null) goto L14;
        Long r107 = (Long) CollectionsKt.getOrNull(r111, r105);
        if (r107 == null) goto L14;
        r106.private_description_id(Long.valueOf(r107.longValue()));
    L14:
        r103.add(r106.build());
        Log.i("[URLPreview] MGetUrlPreviewRequest", "start ,sourceID:" + ((String) ListProtector.get(r100, r105)) + ", sourceTextMD5:" + ((String) ListProtector.get(r101, r105)) + ", sourceType:" + r110.getValue());
        r105 = r105 + 1;
        goto L8
    L15:
        MGetUrlPreviewRequest.Builder r108 = new MGetUrlPreviewRequest.Builder().sync_data_strategy(r102).reqs(r103);
        com.ss.android.lark.sdk.h r113 = new com.ss.android.lark.sdk.h();
        r113.f439879d = RequestPacket.TrafficType.HIGH_PRIORITY;
        a2b.e r109 = this.f411559a;
        Intrinsics.checkNotNull(r108);
        r109.d(r108, r113, new PreviewService$getUrlPreViewEntityList$2(r112, r100, r101, r110));
        return;
    }
}
