package com.larksuite.component.blockit.props;

import android.content.Context;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes24.dex */
public class PropsView extends SpannableTailTextView {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Map<String, Object> f283105e;

    private void setConfig(e r100) {
    }

    public e getConfig() {
        return null;
    }

    public PropsView(Context r100) {
        super(r100);
    }

    public PropsView(Context r100, AttributeSet r101) {
        super(r100, r101);
    }

    public final void x(List r100, Map r101) {
        this.f283105e = r101;
        setConfig(null);
        setText(c.a(r100, this.f283105e));
        setMovementMethod(LinkMovementMethod.getInstance());
    }

    public PropsView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
    }
}
