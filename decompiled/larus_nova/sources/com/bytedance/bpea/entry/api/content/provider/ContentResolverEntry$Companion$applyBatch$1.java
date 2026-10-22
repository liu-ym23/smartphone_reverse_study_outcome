package com.bytedance.bpea.entry.api.content.provider;

import android.content.ContentProviderResult;
import android.content.ContentResolver;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a&\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002 \u0003*\u0012\u0012\u000e\b\u0001\u0012\n \u0003*\u0004\u0018\u00010\u00020\u00020\u00010\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "Landroid/content/ContentProviderResult;", "kotlin.jvm.PlatformType", AbsMethodDelegate.TAG_INVOKE, "()[Landroid/content/ContentProviderResult;"}, k = 3, mv = {1, 1, 16})
final class ContentResolverEntry$Companion$applyBatch$1 extends Lambda implements Function0<ContentProviderResult[]> {
    final /* synthetic */ String $authority;
    final /* synthetic */ ArrayList $operations;
    final /* synthetic */ ContentResolver $this_applyBatch;

    public ContentResolverEntry$Companion$applyBatch$1(ContentResolver r100, String r101, ArrayList r102) {
        this.$this_applyBatch = r100;
        this.$authority = r101;
        this.$operations = r102;
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final ContentProviderResult[] invoke2() {
        return this.$this_applyBatch.applyBatch(this.$authority, this.$operations);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ ContentProviderResult[] invoke() {
        return invoke2();
    }
}
