package lark_bitable.proto;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes42.dex */
public final enum ModelAction extends Enum<ModelAction> implements WireEnum {
    private static final /* synthetic */ ModelAction[] $VALUES = null;
    public static final ProtoAdapter<ModelAction> ADAPTER = null;
    public static final ModelAction VAR_MODEL_ACTION_CLICK_BUTTON = null;
    public static final ModelAction VAR_MODEL_ACTION_COMMENT = null;
    public static final ModelAction VAR_MODEL_ACTION_EDIT = null;
    public static final ModelAction VAR_MODEL_ACTION_JUMP_PAGE = null;
    public static final ModelAction VAR_MODEL_ACTION_VIEW_ATTACHMENT = null;
    private final int value;

    static {
        ModelAction r100 = new ModelAction("VAR_MODEL_ACTION_JUMP_PAGE", 0, 0);
        VAR_MODEL_ACTION_JUMP_PAGE = r100;
        ModelAction r101 = new ModelAction("VAR_MODEL_ACTION_COMMENT", 1, 1);
        VAR_MODEL_ACTION_COMMENT = r101;
        ModelAction r102 = new ModelAction("VAR_MODEL_ACTION_EDIT", 2, 2);
        VAR_MODEL_ACTION_EDIT = r102;
        ModelAction r103 = new ModelAction("VAR_MODEL_ACTION_VIEW_ATTACHMENT", 3, 3);
        VAR_MODEL_ACTION_VIEW_ATTACHMENT = r103;
        ModelAction r104 = new ModelAction("VAR_MODEL_ACTION_CLICK_BUTTON", 4, 4);
        VAR_MODEL_ACTION_CLICK_BUTTON = r104;
        $VALUES = new ModelAction[]{r100, r101, r102, r103, r104};
        ADAPTER = ProtoAdapter.newEnumAdapter(ModelAction.class);
    }

    public static ModelAction[] values() {
        return (ModelAction[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static ModelAction fromValue(int r100) {
        if (r100 == 0) goto L22;
        if (r100 == 1) goto L20;
        if (r100 == 2) goto L18;
        if (r100 == 3) goto L16;
        if (r100 == 4) goto L14;
        return null;
    L14:
        return VAR_MODEL_ACTION_CLICK_BUTTON;
    L16:
        return VAR_MODEL_ACTION_VIEW_ATTACHMENT;
    L18:
        return VAR_MODEL_ACTION_EDIT;
    L20:
        return VAR_MODEL_ACTION_COMMENT;
    L22:
        return VAR_MODEL_ACTION_JUMP_PAGE;
    }

    public static ModelAction valueOf(String r100) {
        return (ModelAction) a.a(ModelAction.class, r100);
    }

    private ModelAction(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
