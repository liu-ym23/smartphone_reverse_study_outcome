package com.ss.android.lark.sticker_office;

import a6c.a;
import a6c.b;
import com.bytedance.i18n.claymore.ClaymoreImpl;
import kotlin.Lazy;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes38.dex */
@ClaymoreImpl(b.class)
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/sticker_office/StickerCoreDependencyImpl;", "Lcom/ss/android/lark/sticker/core/dependency/IStickerCoreDependency;", "<init>", "()V", "resourceDependency", "Lcom/ss/android/lark/sticker/core/dependency/IResourceDependency;", "getResourceDependency", "()Lcom/ss/android/lark/sticker/core/dependency/IResourceDependency;", "sticker-office_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class StickerCoreDependencyImpl implements b {
    public StickerCoreDependencyImpl() {
    }

    @Override // a6c.b
    public a getResourceDependency() {
        Lazy r100 = OfficeStickerModule.f440846a;
        return ((h6c.a) OfficeStickerModule.f440846a.getValue()).getResourceDependency();
    }
}
