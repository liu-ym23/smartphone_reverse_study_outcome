package com.ss.android.lark.todo.impl.features.detail.comment;

import com.bytedance.lark.pb.todo.v1.TodoAttachment;
import com.larus.platform.model.SlashMentionConfig;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class CommentImage {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f442842a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Companion.ImageInfoType f442843b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TodoAttachment f442844c;

    public static final class Companion {

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/todo/impl/features/detail/comment/CommentImage$Companion$ImageInfoType;", "", "<init>", "(Ljava/lang/String;I)V", "PATH", "KEY", "todo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final enum ImageInfoType extends Enum<ImageInfoType> {
            public static final ImageInfoType KEY = null;
            public static final ImageInfoType PATH = null;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ ImageInfoType[] f442845a = null;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final /* synthetic */ EnumEntries f442846b = null;

            public static EnumEntries<ImageInfoType> getEntries() {
                return f442846b;
            }

            static {
                ImageInfoType r100 = new ImageInfoType("PATH", 0);
                PATH = r100;
                ImageInfoType r101 = new ImageInfoType("KEY", 1);
                KEY = r101;
                ImageInfoType[] r102 = {r100, r101};
                f442845a = r102;
                f442846b = EnumEntriesKt.enumEntries(r102);
            }

            public static ImageInfoType[] values() {
                return (ImageInfoType[]) f442845a.clone();
            }

            public static ImageInfoType valueOf(String r100) {
                return (ImageInfoType) r27.a.a(ImageInfoType.class, r100);
            }

            public ImageInfoType(String r100, int r101) {
                super(r100, r101);
            }
        }
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CommentImage) == true) goto L8;
        return false;
    L8:
        CommentImage r101 = (CommentImage) r100;
        if (Intrinsics.areEqual(this.f442842a, r101.f442842a) == true) goto L12;
        return false;
    L12:
        if (this.f442843b == r101.f442843b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f442844c, r101.f442844c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f442842a.hashCode() * 31) + this.f442843b.hashCode()) * 31) + this.f442844c.hashCode();
    }

    public final String toString() {
        return "CommentImage(info=" + this.f442842a + ", infoType=" + this.f442843b + ", attachment=" + this.f442844c + ')';
    }

    public CommentImage(String r100, Companion.ImageInfoType r101, TodoAttachment r102) {
        Intrinsics.checkNotNullParameter(r100, "info");
        Intrinsics.checkNotNullParameter(r101, "infoType");
        Intrinsics.checkNotNullParameter(r102, SlashMentionConfig.MENTION_CONTENT_ATTACHMENT);
        this.f442842a = r100;
        this.f442843b = r101;
        this.f442844c = r102;
    }
}
