package com.ss.android.lark.newemoji.emoji_list;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;

/* JADX INFO: loaded from: classes36.dex */
@Target({ElementType.PARAMETER})
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/ss/android/lark/newemoji/emoji_list/EmojiItemDataType;", "", "Companion", "lark-emoji_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@kotlin.annotation.Target(allowedTargets = {AnnotationTarget.VALUE_PARAMETER})
@Retention(RetentionPolicy.SOURCE)
@kotlin.annotation.Retention(AnnotationRetention.SOURCE)
public @interface EmojiItemDataType {
    public static final a Companion = null;
    public static final int Custom_SPACE = 3;
    public static final int RECENT_EMOJIS = 2;
    public static final int SINGLE_EMOJI = 1;
    public static final int TITLE = 0;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f432929a = null;

        static {
            f432929a = new a();
        }

        public a() {
        }
    }

    static {
        Companion = a.f432929a;
    }
}
