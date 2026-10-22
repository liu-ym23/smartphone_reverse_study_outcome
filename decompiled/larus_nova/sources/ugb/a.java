package ugb;

import android.view.View;
import android.view.ViewGroup;
import com.larus.nova.R;
import com.ss.android.lark.flow.chat.titlebar.view.CoreNavigationBar;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public abstract class a implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f550076a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ViewGroup f550077b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f550078c;

    /* JADX INFO: renamed from: ugb.a$a, reason: collision with other inner class name */
    public static final class C7884a {
    }

    static {
    }

    public a(CoreNavigationBar r100) {
        Intrinsics.checkNotNullParameter(r100, "rootView");
        this.f550076a = r100;
        this.f550077b = (ViewGroup) r100.findViewById(R.id.flow_chat_tag_container);
    }
}
