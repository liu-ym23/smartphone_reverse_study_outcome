package tca;

import android.os.Parcelable;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.MessageStatus;
import com.obric.aiagent.assistant.idl.bean.AppIntentCardData;
import com.obric.aiagent.assistant.idl.bean.AppIntentMessage;
import com.obric.aiagent.assistant.idl.bean.OAppIntentBizContentType;
import com.obric.capabilitykit.entity.app.AppInfoEntity;
import ei9.f;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import xc8.g;

/* JADX INFO: loaded from: classes4.dex */
public final class d implements g {
    @Override // xc8.g
    public final int c() {
        return 106;
    }

    public d() {
    }

    @Override // ei9.g
    public final boolean a(Message r100) {
        Message r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "sourceData");
        if (r101.getMessageStatus() != MessageStatus.MessageStatus_INVISIBLE) goto L6;
        return false;
    L6:
        if (r101.getContentType() == 800) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(r101.getBizContentType(), OAppIntentBizContentType.DOWNLOAD_APP_CARD) == false) goto L64;
        xca.b.f563247a.getClass();
        AppIntentMessage r102 = xca.b.a.a(r101);
        if (r102 == null) goto L65;
        List<Parcelable> r103 = com.obric.assistant.card.utils.c.d(r102);
        if (r103 != null) goto L17;
        r103 = CollectionsKt.emptyList();
    L17:
        List<Parcelable> r104 = r103;
        if ((r104 instanceof Collection) == true) goto L20;
    L22:
        Iterator<T> r105 = r104.iterator();
    L24:
        if (r105.hasNext() == false) goto L33;
        Parcelable r106 = (Parcelable) r105.next();
        if ((r106 instanceof AppIntentCardData) == true) goto L28;
    L30:
        boolean r107 = false;
    L31:
        if (r107 == false) goto L24;
        boolean r108 = true;
    L34:
        if (r108 == false) goto L66;
        int r109 = e.f545491a;
        Intrinsics.checkNotNullParameter(r102, "data");
        ArrayList r110 = (ArrayList) e.b(r102);
        if (r110.isEmpty() == true) goto L67;
        int r111 = e.c(r102);
        if (r110.isEmpty() == true) goto L68;
        Iterator r112 = r110.iterator();
    L44:
        if (r112.hasNext() == false) goto L69;
        if (e.a(r111, (AppInfoEntity) r112.next()) == 0) goto L48;
        boolean r113 = true;
    L49:
        if (r113 == false) goto L44;
        return true;
    L48:
        r113 = false;
        goto L49
    L69:
        return false;
    L68:
        return false;
    L67:
        return false;
    L66:
        return false;
    L28:
        if ((((AppIntentCardData) r106).getAppEntity() instanceof AppInfoEntity) == false) goto L30;
        r107 = true;
    L33:
        r108 = false;
        goto L34
    L20:
        if (r104.isEmpty() == false) goto L22;
    L65:
        return false;
    L64:
        return false;
    }

    @Override // ei9.g
    public final f b(Message r100) {
        Message r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "sourceData");
        return new c(r101);
    }
}
