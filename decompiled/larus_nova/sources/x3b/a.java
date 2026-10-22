package x3b;

import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.chat.entity.chatter.UserPrivateDescription;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f562413a = null;

    static {
        f562413a = new a();
    }

    public a() {
    }

    public final boolean update(Chatter r100, Chatter r101) {
        Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
        Intrinsics.checkNotNullParameter(r101, "pushedChatter");
        if (Intrinsics.areEqual(r100.getId(), r101.getId()) == true) goto L5;
        return false;
    L5:
        UserPrivateDescription r102 = r101.getPrivateDescription();
        if (Intrinsics.areEqual(r100.getPrivateDescription(), r102) == false) goto L8;
        return false;
    L8:
        r100.setPrivateDescription(r102);
        return true;
    }
}
