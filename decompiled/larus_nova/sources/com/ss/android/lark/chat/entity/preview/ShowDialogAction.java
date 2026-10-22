package com.ss.android.lark.chat.entity.preview;

import com.ss.android.lark.export.entity.preview.BaseAction;
import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001:\u0003\u001c\u001d\u001eB7\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u001a\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\b¢\u0006\u0004\b\t\u0010\nJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u001d\u0010\u0012\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\bHÆ\u0003J?\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u001c\b\u0002\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\bHÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR%\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001f"}, d2 = {"Lcom/ss/android/lark/chat/entity/preview/ShowDialogAction;", "Lcom/ss/android/lark/export/entity/preview/BaseAction;", "title", "Lcom/ss/android/lark/chat/entity/preview/ShowDialogAction$DialogItem;", "content", "buttons", "Ljava/util/ArrayList;", "Lcom/ss/android/lark/chat/entity/preview/ShowDialogAction$DialogButton;", "Lkotlin/collections/ArrayList;", "<init>", "(Lcom/ss/android/lark/chat/entity/preview/ShowDialogAction$DialogItem;Lcom/ss/android/lark/chat/entity/preview/ShowDialogAction$DialogItem;Ljava/util/ArrayList;)V", "getTitle", "()Lcom/ss/android/lark/chat/entity/preview/ShowDialogAction$DialogItem;", "getContent", "getButtons", "()Ljava/util/ArrayList;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "DialogButtonType", "DialogButton", "DialogItem", "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ShowDialogAction extends BaseAction {
    private final ArrayList<a> buttons;
    private final DialogItem content;
    private final DialogItem title;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/chat/entity/preview/ShowDialogAction$DialogButtonType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "DEFAULT", "PRIMARY", "DANGER", "Companion", "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum DialogButtonType extends Enum<DialogButtonType> {
        public static final a Companion = null;
        public static final DialogButtonType DANGER = null;
        public static final DialogButtonType DEFAULT = null;
        public static final DialogButtonType PRIMARY = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ DialogButtonType[] f415349a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f415350b = null;
        private final int value;

        public static final class a {
            public a() {
            }
        }

        public static EnumEntries<DialogButtonType> getEntries() {
            return f415350b;
        }

        static {
            DialogButtonType r100 = new DialogButtonType("DEFAULT", 0, 0);
            DEFAULT = r100;
            DialogButtonType r101 = new DialogButtonType("PRIMARY", 1, 1);
            PRIMARY = r101;
            DialogButtonType r102 = new DialogButtonType("DANGER", 2, 2);
            DANGER = r102;
            DialogButtonType[] r103 = {r100, r101, r102};
            f415349a = r103;
            f415350b = EnumEntriesKt.enumEntries(r103);
            Companion = new a();
        }

        public static DialogButtonType[] values() {
            return (DialogButtonType[]) f415349a.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static DialogButtonType valueOf(String r100) {
            return (DialogButtonType) r27.a.a(DialogButtonType.class, r100);
        }

        public DialogButtonType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000bJ&\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0010J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/ss/android/lark/chat/entity/preview/ShowDialogAction$DialogItem;", "Ljava/io/Serializable;", "text", "", "numberOfLines", "", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;)V", "getText", "()Ljava/lang/String;", "getNumberOfLines", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "copy", "(Ljava/lang/String;Ljava/lang/Integer;)Lcom/ss/android/lark/chat/entity/preview/ShowDialogAction$DialogItem;", "equals", "", "other", "", "hashCode", "toString", "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class DialogItem implements Serializable {
        private final Integer numberOfLines;
        private final String text;

        /* JADX WARN: Multi-variable type inference failed */
        public DialogItem() {
            Object[] r100 = 0 == true ? 1 : 0;
            this(null, r100, 3, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ DialogItem copy$default(DialogItem r100, String r101, Integer r102, int r103, Object r104) {
            if ((r103 & 1) == 0) goto L6;
            r101 = r100.text;
        L6:
            if ((r103 & 2) == 0) goto L9;
            r102 = r100.numberOfLines;
        L9:
            return r100.copy(r101, r102);
        }

        public final String component1() {
            return this.text;
        }

        public final Integer component2() {
            return this.numberOfLines;
        }

        public final DialogItem copy(String r100, Integer r101) {
            return new DialogItem(r100, r101);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof DialogItem) == true) goto L8;
            return false;
        L8:
            DialogItem r101 = (DialogItem) r100;
            if (Intrinsics.areEqual(this.text, r101.text) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.numberOfLines, r101.numberOfLines) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            String r100 = this.text;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = r102 * 31;
            Integer r104 = this.numberOfLines;
            if (r104 == null) goto L11;
            r101 = r104.hashCode();
        L11:
            return r103 + r101;
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public String toString() {
            return "DialogItem(text=" + this.text + ", numberOfLines=" + this.numberOfLines + ')';
        }

        public final Integer getNumberOfLines() {
            return this.numberOfLines;
        }

        public final String getText() {
            return this.text;
        }

        public DialogItem(String r100, Integer r101) {
            this.text = r100;
            this.numberOfLines = r101;
        }

        public /* synthetic */ DialogItem(String r100, Integer r101, int r102, DefaultConstructorMarker r103) {
            if ((r102 & 1) == 0) goto L6;
            r100 = "";
        L6:
            if ((r102 & 2) == 0) goto L8;
            r101 = 0;
        L8:
            this(r100, r101);
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f415351a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final DialogButtonType f415352b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f415353c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f415351a, r101.f415351a) == true) goto L12;
            return false;
        L12:
            if (this.f415352b == r101.f415352b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f415353c, r101.f415353c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            String r100 = this.f415351a;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = r102 * 31;
            DialogButtonType r104 = this.f415352b;
            if (r104 != null) goto L9;
            int r105 = 0;
        L10:
            int r106 = (r103 + r105) * 31;
            String r107 = this.f415353c;
            if (r107 == null) goto L15;
            r101 = r107.hashCode();
        L15:
            return r106 + r101;
        L9:
            r105 = r104.hashCode();
            goto L10
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public final String toString() {
            return "DialogButton(text=" + this.f415351a + ", type=" + this.f415352b + ", actionId=" + this.f415353c + ')';
        }

        public final DialogButtonType getType() {
            return this.f415352b;
        }

        public a(String r100, DialogButtonType r101, String r102) {
            this.f415351a = r100;
            this.f415352b = r101;
            this.f415353c = r102;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ShowDialogAction copy$default(ShowDialogAction r100, DialogItem r101, DialogItem r102, ArrayList r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.title;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.content;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.buttons;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final DialogItem component1() {
        return this.title;
    }

    public final DialogItem component2() {
        return this.content;
    }

    public final ArrayList<a> component3() {
        return this.buttons;
    }

    public final ShowDialogAction copy(DialogItem r100, DialogItem r101, ArrayList<a> r102) {
        return new ShowDialogAction(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ShowDialogAction) == true) goto L8;
        return false;
    L8:
        ShowDialogAction r101 = (ShowDialogAction) r100;
        if (Intrinsics.areEqual(this.title, r101.title) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.content, r101.content) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.buttons, r101.buttons) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        DialogItem r100 = this.title;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        DialogItem r104 = this.content;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        ArrayList<a> r107 = this.buttons;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return r106 + r101;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "ShowDialogAction(title=" + this.title + ", content=" + this.content + ", buttons=" + this.buttons + ')';
    }

    public final ArrayList<a> getButtons() {
        return this.buttons;
    }

    public final DialogItem getContent() {
        return this.content;
    }

    public final DialogItem getTitle() {
        return this.title;
    }

    public ShowDialogAction(DialogItem r100, DialogItem r101, ArrayList<a> r102) {
        this.title = r100;
        this.content = r101;
        this.buttons = r102;
    }
}
