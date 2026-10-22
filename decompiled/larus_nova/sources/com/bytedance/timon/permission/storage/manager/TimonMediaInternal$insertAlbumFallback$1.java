package com.bytedance.timon.permission.storage.manager;

import android.app.Activity;
import android.net.Uri;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.bytedance.timon.permission.storage.TimonMedia;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 7, 1}, xi = 48)
final class TimonMediaInternal$insertAlbumFallback$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Activity $activity;
    final /* synthetic */ TimonMedia.ExtraInfo $info;
    final /* synthetic */ TimonMediaInternal.a<Uri> $internalCallback;
    final /* synthetic */ ah7.a $model;

    public TimonMediaInternal$insertAlbumFallback$1(Activity r100, ah7.a r101, TimonMedia.ExtraInfo r102, TimonMediaInternal.a<Uri> r103) {
        this.$activity = r100;
        this.$info = r102;
        this.$internalCallback = r103;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        int r100 = bh7.b.f19051a;
        bh7.b.a(this.$activity, this.$info, this.$internalCallback);
        throw null;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
