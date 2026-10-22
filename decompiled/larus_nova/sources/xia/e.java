package xia;

import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.ContactEntity;
import com.obric.capabilitykit.entity.app.FileEntity;
import com.obric.capabilitykit.entity.app.GroupChatEntity;
import com.obric.capabilitykit.entity.app.MessageEntity;
import com.obric.capabilitykit.entity.enums.MessageStatusTypeEnum;
import com.obric.capabilitykit.entity.enums.MessageTypeEnum;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class e implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f563984a = null;

    static {
        f563984a = new e();
    }

    public e() {
    }

    @Override // xia.c
    public final int a(AppEntity r100) {
        Intrinsics.checkNotNullParameter(r100, "instance");
        if ((r100 instanceof MessageEntity) == false) goto L21;
        MessageEntity r101 = (MessageEntity) r100;
        int r102 = ((r101.getTelephones().hashCode() + 0) * 31) + r101.getText().hashCode();
        List<ContactEntity> r103 = r101.getContacts();
        if (r103 == null) goto L7;
        r102 = (r102 * 31) + r103.hashCode();
    L7:
        MessageTypeEnum r104 = r101.getMessageType();
        if (r104 == null) goto L10;
        r102 = (r102 * 31) + r104.name().hashCode();
    L10:
        List<FileEntity> r105 = r101.getFiles();
        if (r105 == null) goto L13;
        r102 = (r102 * 31) + r105.hashCode();
    L13:
        MessageStatusTypeEnum r106 = r101.getMessageStatusType();
        if (r106 == null) goto L16;
        r102 = (r102 * 31) + r106.name().hashCode();
    L16:
        GroupChatEntity r107 = r101.getGroupChat();
        if (r107 != null) goto L19;
        return r102;
    L19:
        return (r102 * 31) + r107.hashCode();
    L21:
        throw new IllegalStateException("Check failed.".toString());
    }
}
