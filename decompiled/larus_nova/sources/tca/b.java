package tca;

import android.os.Parcelable;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.MessageStatus;
import com.obric.aiagent.assistant.idl.bean.AppIntentCardData;
import com.obric.aiagent.assistant.idl.bean.AppIntentMessage;
import com.obric.aiagent.assistant.idl.bean.OAppIntentBizContentType;
import com.obric.capabilitykit.entity.app.AppInfoEntity;
import ei9.f;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import xc8.g;

/* JADX INFO: loaded from: classes4.dex */
public final class b implements g {
    @Override // xc8.g
    public final int c() {
        return 104;
    }

    public b() {
    }

    @Override // ei9.g
    public final boolean a(Message r100) {
        Message r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "sourceData");
        boolean r102 = false;
        if (r101.getMessageStatus() != MessageStatus.MessageStatus_INVISIBLE) goto L6;
        return false;
    L6:
        if (r101.getContentType() == 800) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(r101.getBizContentType(), OAppIntentBizContentType.DOWNLOAD_APP_CARD) == false) goto L42;
        xca.b.f563247a.getClass();
        AppIntentMessage r103 = xca.b.a.a(r101);
        if (r103 != null) goto L13;
        return true;
    L13:
        List<Parcelable> r104 = com.obric.assistant.card.utils.c.d(r103);
        if (r104 != null) goto L16;
        r104 = CollectionsKt.emptyList();
    L16:
        List<Parcelable> r105 = r104;
        if ((r105 instanceof Collection) == true) goto L19;
    L21:
        Iterator<T> r106 = r105.iterator();
    L23:
        if (r106.hasNext() == false) goto L33;
        Parcelable r107 = (Parcelable) r106.next();
        if ((r107 instanceof AppIntentCardData) == true) goto L27;
    L29:
        boolean r108 = false;
    L30:
        if (r108 == false) goto L23;
        r102 = true;
        goto L33
    L27:
        if ((((AppIntentCardData) r107).getAppEntity() instanceof AppInfoEntity) == false) goto L29;
        r108 = true;
    L33:
        return !r102;
    L19:
        if (r105.isEmpty() == false) goto L21;
    L42:
        return false;
    }

    @Override // ei9.g
    public final f b(Message r100) {
        Message r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "sourceData");
        return new a(r101);
    }
}
