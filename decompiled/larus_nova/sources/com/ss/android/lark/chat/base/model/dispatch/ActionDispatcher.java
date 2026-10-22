package com.ss.android.lark.chat.base.model.dispatch;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes35.dex */
public class ActionDispatcher extends ViewModel {
    private List<a> mActionHandlers;

    public interface a {
        boolean a(com.ss.android.lark.chat.base.model.dispatch.a r100);
    }

    public ActionDispatcher() {
        this.mActionHandlers = new ArrayList();
    }

    public static ActionDispatcher from(FragmentActivity r100) {
        return (ActionDispatcher) ViewModelProviders.of(r100).get(ActionDispatcher.class);
    }

    public void dispatch(com.ss.android.lark.chat.base.model.dispatch.a r100) {
        if (this.mActionHandlers.isEmpty() == true) goto L9;
        Iterator<a> r101 = this.mActionHandlers.iterator();
    L6:
        if (r101.hasNext() == false) goto L13;
        if (r101.next().a(r100) == false) goto L6;
        return;
    L13:
        return;
    }

    public <Result> Result dispatchSyncQuery(j<?, Result> r100) {
        if (this.mActionHandlers.isEmpty() == true) goto L11;
        Iterator<a> r101 = this.mActionHandlers.iterator();
    L6:
        if (r101.hasNext() == false) goto L16;
        if (r101.next().a(r100) == false) goto L6;
        return r100.f411787a;
    L16:
        return null;
    L11:
        return null;
    }

    public void registerActionListener(a r100) {
        if (this.mActionHandlers.contains(r100) == true) goto L6;
        this.mActionHandlers.add(r100);
        return;
    }

    public void unregisterActionHandler(a r100) {
        this.mActionHandlers.remove(r100);
    }
}
