package wnb;

import android.view.View;
import com.ss.android.lark.keyboard.base.inputinner.Direction;
import com.ss.android.lark.keyboard.base.inputinner.DirectionInParent;
import com.ss.android.lark.keyboard.base.inputinner.InputInnerVisibilityMode;
import com.ss.android.lark.keyboard.editor.inject.InputInnerController;
import wnb.b;

/* JADX INFO: loaded from: classes36.dex */
public interface b<E extends b<E>> {

    public interface a<E extends b<E>> {
    }

    View a();

    e b();

    DirectionInParent c();

    InputInnerVisibilityMode d();

    void e(InputInnerController r100);

    Direction getDirection();

    a<E> getKey();

    c h();

    boolean i();

    void onDestroy();

    void setKeyboard(com.ss.android.lark.keyboard.b r100);
}
