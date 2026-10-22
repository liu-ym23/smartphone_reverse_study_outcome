package com.ss.android.lark.coremd.facade.mdeditor.link;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.KeyboardBaseModule;
import com.ss.android.lark.keyboard.dtocompat.UrlInlinePreviewEntity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import v7b.n;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Lcom/larksuite/framework/callback/IGetDataCallback;", "Lcom/ss/android/lark/keyboard/dtocompat/UrlInlinePreviewEntity;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {2, 1, 0}, xi = 48)
final class IMTemporaryPreviewLoader$loadLinkPreview$1 extends Lambda implements Function1<IGetDataCallback<UrlInlinePreviewEntity>, Unit> {
    final /* synthetic */ n $link;

    public IMTemporaryPreviewLoader$loadLinkPreview$1(n r100) {
        this.$link = r100;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(IGetDataCallback<UrlInlinePreviewEntity> r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        KeyboardBaseModule.a().getUrlInlineFromContent(this.$link.f553561j, r100);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(IGetDataCallback<UrlInlinePreviewEntity> r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
