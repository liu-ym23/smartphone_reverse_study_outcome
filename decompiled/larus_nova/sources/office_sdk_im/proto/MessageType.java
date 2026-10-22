package office_sdk_im.proto;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes42.dex */
public final enum MessageType extends Enum<MessageType> implements WireEnum {
    private static final /* synthetic */ MessageType[] $VALUES = null;
    public static final ProtoAdapter<MessageType> ADAPTER = null;
    public static final MessageType VAR_MESSAGE_TYPE_DOUBAO = null;
    private final int value;

    static {
        MessageType r100 = new MessageType("VAR_MESSAGE_TYPE_DOUBAO", 0, 0);
        VAR_MESSAGE_TYPE_DOUBAO = r100;
        $VALUES = new MessageType[]{r100};
        ADAPTER = ProtoAdapter.newEnumAdapter(MessageType.class);
    }

    public static MessageType[] values() {
        return (MessageType[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static MessageType fromValue(int r100) {
        if (r100 == 0) goto L6;
        return null;
    L6:
        return VAR_MESSAGE_TYPE_DOUBAO;
    }

    public static MessageType valueOf(String r100) {
        return (MessageType) a.a(MessageType.class, r100);
    }

    private MessageType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
