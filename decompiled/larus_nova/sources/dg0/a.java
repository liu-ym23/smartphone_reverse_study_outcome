package dg0;

import com.bytedance.android.livesdkapi.depend.message.IMicrophoneItem;
import com.bytedance.android.livesdkapi.depend.message.MicrophoneType;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes46.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f468366a = 0;

    static {
    }

    public static IMicrophoneItem a(List r100) {
        List r101 = r100;
        if (r101 != null) goto L5;
    L8:
        boolean r102 = true;
    L10:
        if (r102 == false) goto L12;
        return null;
    L12:
        Iterator r103 = r100.iterator();
    L14:
        if (r103.hasNext() == false) goto L18;
        IMicrophoneItem r104 = (IMicrophoneItem) r103.next();
        if (r104.getMicrophoneType() != MicrophoneType.Golden.ordinal()) goto L14;
        return r104;
    L18:
        return null;
    L5:
        if (r101.isEmpty() == true) goto L8;
        r102 = false;
        goto L10
    }
}
