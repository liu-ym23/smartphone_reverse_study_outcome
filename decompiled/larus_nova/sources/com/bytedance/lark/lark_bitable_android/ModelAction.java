package com.bytedance.lark.lark_bitable_android;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u0006\u0010\u0005\u001a\u00020\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/bytedance/lark/lark_bitable_android/ModelAction;", "", "(Ljava/lang/String;I)V", "into", "Llark_bitable/proto/ModelAction;", "intoInt", "", "JumpPage", "Comment", "Edit", "ViewAttachment", "ClickButton", "Companion", "lark_bitable_android_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final enum ModelAction extends Enum<ModelAction> {
    public static final ModelAction ClickButton = null;
    public static final ModelAction Comment = null;
    public static final a Companion = null;
    public static final ModelAction Edit = null;
    public static final ModelAction JumpPage = null;
    public static final ModelAction ViewAttachment = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ModelAction[] f252964a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f252965b = null;

    public static final class a {
        public a() {
        }
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f252966a = null;

        static {
            int[] r100 = new int[ModelAction.values().length];
            r100[ModelAction.JumpPage.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L15:
            r100[ModelAction.Comment.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L23:
            r100[ModelAction.Edit.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L17:
            r100[ModelAction.ViewAttachment.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L19:
            r100[ModelAction.ClickButton.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L8:
            f252966a = r100;
        }
    }

    public static EnumEntries<ModelAction> getEntries() {
        return f252965b;
    }

    public static ModelAction valueOf(String r100) {
        return (ModelAction) r27.a.a(ModelAction.class, r100);
    }

    public static ModelAction[] values() {
        return (ModelAction[]) f252964a.clone();
    }

    static {
        ModelAction r100 = new ModelAction("JumpPage", 0);
        JumpPage = r100;
        ModelAction r101 = new ModelAction("Comment", 1);
        Comment = r101;
        ModelAction r102 = new ModelAction("Edit", 2);
        Edit = r102;
        ModelAction r103 = new ModelAction("ViewAttachment", 3);
        ViewAttachment = r103;
        ModelAction r104 = new ModelAction("ClickButton", 4);
        ClickButton = r104;
        ModelAction[] r105 = {r100, r101, r102, r103, r104};
        f252964a = r105;
        f252965b = EnumEntriesKt.enumEntries(r105);
        Companion = new a();
    }

    public final lark_bitable.proto.ModelAction into() {
        int r100 = b.f252966a[ordinal()];
        if (r100 == 1) goto L19;
        if (r100 == 2) goto L23;
        if (r100 == 3) goto L22;
        if (r100 == 4) goto L21;
        if (r100 != 5) goto L14;
        return lark_bitable.proto.ModelAction.VAR_MODEL_ACTION_CLICK_BUTTON;
    L14:
        throw new NoWhenBranchMatchedException();
    L21:
        return lark_bitable.proto.ModelAction.VAR_MODEL_ACTION_VIEW_ATTACHMENT;
    L22:
        return lark_bitable.proto.ModelAction.VAR_MODEL_ACTION_EDIT;
    L23:
        return lark_bitable.proto.ModelAction.VAR_MODEL_ACTION_COMMENT;
    L19:
        return lark_bitable.proto.ModelAction.VAR_MODEL_ACTION_JUMP_PAGE;
    }

    public final int intoInt() {
        int r100 = b.f252966a[ordinal()];
        if (r100 != 1) goto L5;
        return 0;
    L5:
        if (r100 != 2) goto L7;
        return 1;
    L7:
        if (r100 != 3) goto L9;
        return 2;
    L9:
        if (r100 != 4) goto L11;
        return 3;
    L11:
        if (r100 != 5) goto L14;
        return 4;
    L14:
        throw new NoWhenBranchMatchedException();
    }

    @JvmStatic
    public static final ModelAction fromInt(int r100) {
        Companion.getClass();
        if (r100 == 0) goto L19;
        if (r100 == 1) goto L23;
        if (r100 == 2) goto L22;
        if (r100 == 3) goto L21;
        if (r100 != 4) goto L14;
        return ClickButton;
    L14:
        throw new RuntimeException("Unmatched primitive enum value: ModelAction with ");
    L21:
        return ViewAttachment;
    L22:
        return Edit;
    L23:
        return Comment;
    L19:
        return JumpPage;
    }

    public ModelAction(String r100, int r101) {
        super(r100, r101);
    }
}
