package com.larus.bmhome.chat.outerinput;

import androidx.fragment.app.Fragment;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bg\u0018\u0000 \b2\u00020\u0001:\u0001\bJ\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\t"}, d2 = {"Lcom/larus/bmhome/chat/outerinput/IOuterChatInputProvider;", "", "providerController", "Lcom/larus/bmhome/chat/outerinput/IOuterChatInputController;", "tabPage", "Landroidx/fragment/app/Fragment;", "tabKey", "", "Companion", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IOuterChatInputProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f308376a = null;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u001d\u0010\u0004\u001a\u0004\u0018\u00010\u00018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/larus/bmhome/chat/outerinput/IOuterChatInputProvider$Companion;", "Lcom/larus/bmhome/chat/outerinput/IOuterChatInputProvider;", "<init>", "()V", "impl", "getImpl", "()Lcom/larus/bmhome/chat/outerinput/IOuterChatInputProvider;", "impl$delegate", "Lkotlin/Lazy;", "providerController", "Lcom/larus/bmhome/chat/outerinput/IOuterChatInputController;", "tabPage", "Landroidx/fragment/app/Fragment;", "tabKey", "", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion implements IOuterChatInputProvider {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ Companion f308377b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final Lazy<IOuterChatInputProvider> f308378c = null;

        private Companion() {
        }

        static {
            f308377b = new Companion();
            f308378c = LazyKt.lazy(new d());
        }

        @Override // com.larus.bmhome.chat.outerinput.IOuterChatInputProvider
        public final c a(Fragment r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "tabPage");
            Intrinsics.checkNotNullParameter(r101, "tabKey");
            IOuterChatInputProvider r102 = f308378c.getValue();
            if (r102 != null) goto L7;
            return null;
        L7:
            return r102.a(r100, r101);
        }
    }

    static {
        f308376a = Companion.f308377b;
    }

    c a(Fragment r100, String r101);
}
