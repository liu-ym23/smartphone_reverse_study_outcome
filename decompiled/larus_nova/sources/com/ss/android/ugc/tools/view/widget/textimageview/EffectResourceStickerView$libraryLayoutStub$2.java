package com.ss.android.ugc.tools.view.widget.textimageview;

import android.view.ViewStub;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/view/ViewStub;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 1})
final class EffectResourceStickerView$libraryLayoutStub$2 extends Lambda implements Function0<ViewStub> {
    final /* synthetic */ EffectResourceStickerView this$0;

    public EffectResourceStickerView$libraryLayoutStub$2(EffectResourceStickerView r100) {
        this.this$0 = r100;
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final ViewStub invoke() {
        return (ViewStub) this.this$0.findViewById(R.id.view_stub_library_layout);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ ViewStub invoke() {
        return invoke();
    }
}
