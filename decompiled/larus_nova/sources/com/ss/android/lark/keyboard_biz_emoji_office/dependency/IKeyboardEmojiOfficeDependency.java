package com.ss.android.lark.keyboard_biz_emoji_office.dependency;

import androidx.fragment.app.Fragment;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes36.dex */
public interface IKeyboardEmojiOfficeDependency {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f431071a = null;

    public static final class Companion {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Companion f431072a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Lazy<IKeyboardEmojiOfficeDependency> f431073b = null;

        public Companion() {
        }

        static {
            f431072a = new Companion();
            f431073b = LazyKt.lazy(IKeyboardEmojiOfficeDependency$Companion$instance$2.INSTANCE);
        }
    }

    static {
        f431071a = Companion.f431072a;
    }

    Fragment newCustomStickerFragment();
}
