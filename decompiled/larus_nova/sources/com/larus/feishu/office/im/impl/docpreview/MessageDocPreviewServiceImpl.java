package com.larus.feishu.office.im.impl.docpreview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.bytedance.lark.pb.basic.v1.SyncDataStrategy;
import com.larus.bmhome.chat.doclink.IMessageDocPreviewService;
import com.larus.bmhome.chat.doclink.MessageDocPreviewRepository;
import com.larus.bmhome.chat.doclink.h;
import com.larus.bmhome.chat.doclink.i;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.chat.core.dependency.BrowserDependency;
import com.ss.android.lark.export.e;
import com.ss.android.lark.export.entity.preview.ColorIcon;
import com.ss.android.lark.export.entity.preview.ThemeColor;
import com.ss.android.lark.export.entity.preview.UDIcon;
import com.ss.android.lark.export.entity.preview.UnifiedHeaderInfo;
import com.ss.android.lark.export.entity.preview.UrlInlinePreviewEntity;
import com.ss.android.lark.officesdk.api.api.OfficeSDKGlobalApi;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import sza.c;
import xp9.n;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 *2\u00020\u0001:\u0001*B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\b\u001a\u00020\tH\u0016JJ\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\r2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u000f2\u001e\u0010\u0010\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00120\u000f\u0012\u0004\u0012\u00020\u000b0\u0011H\u0016J\u001a\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0012H\u0016J8\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00122\b\u0010\u0019\u001a\u0004\u0018\u00010\u00142\u0014\u0010\u0010\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0012\u0004\u0012\u00020\u000b0\u0011H\u0016J \u0010\u001a\u001a\u0004\u0018\u00010\u0012*\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00062\b\u0010\u001d\u001a\u0004\u0018\u00010\u0006H\u0002J8\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00120\u000f*\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u001b0\u000f2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u000fH\u0002J\n\u0010\u001f\u001a\u0004\u0018\u00010 H\u0002J \u0010!\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00122\u0006\u0010#\u001a\u00020\u0007H\u0002J\u0012\u0010$\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0017\u001a\u00020\u0012H\u0002J\u000e\u0010%\u001a\u0004\u0018\u00010\u0007*\u00020\u0012H\u0002J\u000e\u0010&\u001a\u0004\u0018\u00010'*\u00020\u0012H\u0002J\u000e\u0010(\u001a\u0004\u0018\u00010)*\u00020\u0012H\u0002R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/larus/feishu/office/im/impl/docpreview/MessageDocPreviewServiceImpl;", "Lcom/larus/bmhome/chat/doclink/IMessageDocPreviewService;", "<init>", "()V", "inlinePreviewCache", "", "", "Lcom/ss/android/lark/export/entity/preview/UrlInlinePreviewEntity;", "isSupported", "", "getPreviewEntities", "", "previewIds", "", "fallbackUrlsByPreviewId", "", "callback", "Lkotlin/Function1;", "Lcom/larus/bmhome/chat/doclink/MessageDocPreviewEntity;", "getPreviewIconDrawable", "Landroid/graphics/drawable/Drawable;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "preview", "loadPreviewIconDrawable", "defaultDrawable", "toMessageDocPreviewEntity", "Lcom/ss/android/lark/export/entity/UrlCardPreviewEntity;", "fallbackPreviewId", "fallbackUrl", "toMessageDocPreviewEntities", "getUrlPreviewService", "Lcom/ss/android/lark/biz/officesdk/im/preview/IOfficeUrlPreviewService;", "cacheInlinePreview", "rawPreviewId", BrowserDependency.UrlClickType.INLINE, "findInlinePreview", "toFallbackInlinePreview", "toFallbackUdIcon", "Lcom/ss/android/lark/export/entity/preview/UDIcon;", "toFallbackThemeColor", "Lcom/ss/android/lark/export/entity/preview/ThemeColor;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MessageDocPreviewServiceImpl implements IMessageDocPreviewService {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f343207b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, UrlInlinePreviewEntity> f343208a;

    public static final class a {
    }

    static {
    }

    public static c d() {
        Object r100 = n.f564774a;
        if ((r100 instanceof OfficeSDKGlobalApi) == false) goto L5;
        OfficeSDKGlobalApi r101 = (OfficeSDKGlobalApi) r100;
    L6:
        if (r101 == null) goto L8;
        aza.c r102 = (aza.c) r101.getService(aza.c.class);
    L10:
        if ((r102 instanceof aza.c) == true) goto L13;
        r102 = null;
    L13:
        if (r102 != null) goto L15;
        return null;
    L15:
        return r102.N1();
    L8:
        r102 = null;
        goto L10
    L5:
        r101 = null;
        goto L6
    }

    public MessageDocPreviewServiceImpl() {
        this.f343208a = Collections.synchronizedMap(new MessageDocPreviewServiceImpl$inlinePreviewCache$1());
    }

    @Override // com.larus.bmhome.chat.doclink.IMessageDocPreviewService
    public final boolean isSupported() {
        if (d() == null) goto L5;
        return true;
    L5:
        return false;
    }

    public static UrlInlinePreviewEntity e(h r110) {
        String r100 = r110.f302912d;
        boolean r101 = false;
        if (r100 != null) goto L5;
    L8:
        boolean r102 = true;
    L10:
        if (r102 == false) goto L20;
        String r103 = r110.f302918j;
        if (r103 != null) goto L14;
    L17:
        boolean r104 = true;
    L18:
        if (r104 == false) goto L20;
        UDIcon r105 = null;
    L40:
        String r106 = r110.f302919k;
        if (r106 != null) goto L43;
    L44:
        r101 = true;
    L45:
        boolean r107 = !r101;
        if (r105 != null) goto L50;
        if (r107 == true) goto L50;
        return null;
    L50:
        return new UrlInlinePreviewEntity.Builder().previewId(r110.f302909a).netIconKey(r110.f302919k).udIcon(r105).build();
    L43:
        if (StringsKt.isBlank(r106) == false) goto L45;
    L14:
        if (StringsKt.isBlank(r103) == true) goto L17;
        r104 = false;
    L20:
        String r108 = r110.f302912d;
        if (r108 != null) goto L23;
        r108 = "";
    L23:
        String r109 = r110.f302913e;
        if (r109 == null) goto L26;
    L34:
        Integer r111 = r110.f302914f;
        ThemeColor.KeyType.a r112 = ThemeColor.KeyType.Companion;
        Integer r113 = r110.f302915g;
        r112.getClass();
        ThemeColor.KeyType r114 = ThemeColor.KeyType.a.a(r113);
        Integer r115 = r110.f302916h;
        Integer r116 = r110.f302917i;
        if (r116 == null) goto L37;
        int r117 = r116.intValue();
    L38:
        ThemeColor r118 = new ThemeColor(r109, r111, new ThemeColor.Key(r114, r115, r117));
    L39:
        r105 = new UDIcon(r108, r118, r110.f302918j);
        goto L40
    L37:
        r117 = 100;
        goto L38
    L26:
        if (r110.f302914f != null) goto L34;
        if (r110.f302915g != null) goto L34;
        if (r110.f302916h != null) goto L34;
        if (r110.f302917i != null) goto L34;
        r118 = null;
        goto L39
    L5:
        if (StringsKt.isBlank(r100) == true) goto L8;
        r102 = false;
        goto L10
    }

    @Override // com.larus.bmhome.chat.doclink.IMessageDocPreviewService
    public final Drawable b(Context r100, h r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "preview");
        UrlInlinePreviewEntity r102 = this.f343208a.get(r101.f302909a);
        if (r102 != null) goto L5;
        r102 = this.f343208a.get(r101.f302911c);
    L5:
        Object r103 = null;
        if (r102 != null) goto L10;
        r102 = e(r101);
        if (r102 != null) goto L10;
        return null;
    L10:
        UnifiedHeaderInfo r104 = r102.getHeaderInfo();
        if (r104 == null) goto L21;
        ColorIcon r105 = r104.getIcon();
        if (r105 == null) goto L21;
        UDIcon r106 = r105.getUdIcon();
        if (r106 == null) goto L21;
        if (r102.getUseColorIcon() == true) goto L20;
        r106 = null;
    L20:
        if (r106 == null) goto L21;
    L35:
        Result.Companion r107 = Result.Companion;     // Catch: Throwable -> L24
        int r108 = e.f420647a;     // Catch: Throwable -> L24
        Object r109 = Result.m9449constructorimpl(e.b(r100, r106));     // Catch: Throwable -> L24
    L26:
        Throwable r110 = Result.m9452exceptionOrNullimpl(r109);
        if (r110 == null) goto L30;
        FLogger.f375446a.w("MessageDocPreviewService", "getPreviewIconDrawable ud icon failed=" + r110.getMessage());
    L30:
        if (Result.m9455isFailureimpl(r109) == true) goto L34;
        r103 = r109;
    L34:
        return (Drawable) r103;
    L24:
        th = move-exception;
        Result.Companion r111 = Result.Companion;
        r109 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L21:
        r106 = r102.getUdIcon();
        goto L35
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [com.larus.feishu.office.im.impl.docpreview.MessageDocPreviewServiceImpl$getPreviewEntities$1] */
    @Override // com.larus.bmhome.chat.doclink.IMessageDocPreviewService
    public final void c(List r100, final Map r101, final MessageDocPreviewRepository.b r102) {
        Intrinsics.checkNotNullParameter(r100, "previewIds");
        Intrinsics.checkNotNullParameter(r101, "fallbackUrlsByPreviewId");
        Intrinsics.checkNotNullParameter(r102, "callback");
        if (r100.isEmpty() == false) goto L6;
        r102.invoke(MapsKt.emptyMap());
        return;
    L6:
        c r103 = d();
        if (r103 != 0) goto L10;
        FLogger.f375446a.i("MessageDocPreviewService", "getPreviewEntities skip, urlPreviewService is null");
        r102.invoke(MapsKt.emptyMap());
        return;
    L10:
        FLogger.f375446a.i("MessageDocPreviewService", "getPreviewEntities request previewIdCount=" + r100.size());
        r103.a(r100, SyncDataStrategy.TRY_LOCAL, new MessageDocPreviewServiceImpl$getPreviewEntities$1(r102, this, r101));
    }

    @Override // com.larus.bmhome.chat.doclink.IMessageDocPreviewService
    public final void a(Context r100, h r101, Drawable r102, i r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "preview");
        Intrinsics.checkNotNullParameter(r103, "callback");
        UrlInlinePreviewEntity r104 = this.f343208a.get(r101.f302909a);
        if (r104 != null) goto L5;
        r104 = this.f343208a.get(r101.f302911c);
    L5:
        if (r104 != null) goto L7;
        r104 = e(r101);
    L7:
        if (r104 != null) goto L18;
        r103.invoke(r102);
        return;
    L18:
        Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L12
        e.a(r100, r104, new com.larus.feishu.office.im.impl.docpreview.a(r103), r102);     // Catch: Throwable -> L12
        Object r106 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L12
    L14:
        Throwable r107 = Result.m9452exceptionOrNullimpl(r106);
        if (r107 == null) goto L20;
        FLogger.f375446a.w("MessageDocPreviewService", "loadPreviewIconDrawable failed=" + r107.getMessage());
        r103.invoke(r102);
        return;
    L20:
        return;
    L12:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L14
    }
}
