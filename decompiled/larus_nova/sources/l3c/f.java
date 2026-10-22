package l3c;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.ss.android.lark.scaffold.IComponent;
import com.ss.android.lark.scaffold.ScaffoldDsl;

/* JADX INFO: loaded from: classes38.dex */
@ScaffoldDsl
public interface f {
    <T extends IComponent> T a(Class<T> r100);

    <T extends g> T b(Class<T> r100);

    FragmentActivity getActivity();

    Fragment getFragment();
}
