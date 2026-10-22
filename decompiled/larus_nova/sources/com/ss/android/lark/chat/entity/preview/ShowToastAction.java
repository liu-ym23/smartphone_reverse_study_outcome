package com.ss.android.lark.chat.entity.preview;

import com.ss.android.lark.export.entity.preview.BaseAction;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0015B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0096\u0002J\b\u0010\u0014\u001a\u00020\u0007H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0016"}, d2 = {"Lcom/ss/android/lark/chat/entity/preview/ShowToastAction;", "Lcom/ss/android/lark/export/entity/preview/BaseAction;", "type", "Lcom/ss/android/lark/chat/entity/preview/ShowToastAction$ToastType;", "content", "", "duration", "", "<init>", "(Lcom/ss/android/lark/chat/entity/preview/ShowToastAction$ToastType;Ljava/lang/String;I)V", "getType", "()Lcom/ss/android/lark/chat/entity/preview/ShowToastAction$ToastType;", "getContent", "()Ljava/lang/String;", "getDuration", "()I", "equals", "", "other", "", "hashCode", "ToastType", "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ShowToastAction extends BaseAction {
    private final String content;
    private final int duration;
    private final ToastType type;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\rB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\f\u001a\u00020\u0003R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\u000e"}, d2 = {"Lcom/ss/android/lark/chat/entity/preview/ShowToastAction$ToastType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "SUCCESS", "ERROR", "INFO", "WARNING", "getNumber", "Companion", "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum ToastType extends Enum<ToastType> {
        public static final a Companion = null;
        public static final ToastType ERROR = null;
        public static final ToastType INFO = null;
        public static final ToastType SUCCESS = null;
        public static final ToastType WARNING = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ToastType[] f415354a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f415355b = null;
        private final int value;

        public static final class a {
            public a() {
            }
        }

        public static EnumEntries<ToastType> getEntries() {
            return f415355b;
        }

        static {
            ToastType r100 = new ToastType("SUCCESS", 0, 1);
            SUCCESS = r100;
            ToastType r101 = new ToastType("ERROR", 1, 2);
            ERROR = r101;
            ToastType r102 = new ToastType("INFO", 2, 3);
            INFO = r102;
            ToastType r103 = new ToastType("WARNING", 3, 4);
            WARNING = r103;
            ToastType[] r104 = {r100, r101, r102, r103};
            f415354a = r104;
            f415355b = EnumEntriesKt.enumEntries(r104);
            Companion = new a();
        }

        public static ToastType[] values() {
            return (ToastType[]) f415354a.clone();
        }

        public final int getNumber() {
            return this.value;
        }

        public final int getValue() {
            return this.value;
        }

        public static ToastType valueOf(String r100) {
            return (ToastType) r27.a.a(ToastType.class, r100);
        }

        public ToastType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public int hashCode() {
        return (((this.type.hashCode() * 31) + this.content.hashCode()) * 31) + this.duration;
    }

    public final String getContent() {
        return this.content;
    }

    public final int getDuration() {
        return this.duration;
    }

    public final ToastType getType() {
        return this.type;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ShowToastAction) == true) goto L8;
        return false;
    L8:
        ShowToastAction r101 = (ShowToastAction) r100;
        if (this.type == r101.type) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.content, r101.content) == true) goto L15;
        return false;
    L15:
        if (this.duration == r101.duration) goto L17;
        return false;
    L17:
        return true;
    }

    public ShowToastAction(ToastType r100, String r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r101, "content");
        this.type = r100;
        this.content = r101;
        this.duration = r102;
    }
}
