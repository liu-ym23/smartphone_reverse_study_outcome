package s0c;

import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import com.ss.android.lark.photoeditor.impl.editaction.CropAndRotationAction;
import com.ss.android.photoeditor.crop_rotate.PhotoClipView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import pfc.f;

/* JADX INFO: loaded from: classes37.dex */
public final class a {
    static {
    }

    public static ArrayList a(List r100) {
        Intrinsics.checkNotNullParameter(r100, SlcCommonAction.KEY_ACTIONS);
        ArrayList r101 = new ArrayList();
        Iterator r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L8;
        f.a r103 = (f.a) r102.next();
        if ((r103 instanceof PhotoClipView.b) == false) goto L4;
        CropAndRotationAction r104 = new CropAndRotationAction();
        PhotoClipView.b r105 = (PhotoClipView.b) r103;
        r104.f438552a = r105.f449189c;
        r104.f438553b = r105.f449190d;
        r104.f438554c = r105.f449191e;
        r101.add(r104);
        goto L4
    L8:
        return r101;
    }
}
