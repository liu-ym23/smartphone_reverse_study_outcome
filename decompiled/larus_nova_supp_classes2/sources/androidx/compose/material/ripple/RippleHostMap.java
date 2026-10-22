package androidx.compose.material.ripple;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0007H\u0086\u0002J\u0013\u0010\r\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000b\u001a\u00020\u0006H\u0086\u0002J\u0013\u0010\r\u001a\u0004\u0018\u00010\u00062\u0006\u0010\f\u001a\u00020\u0007H\u0086\u0002J\u000e\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0006R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Landroidx/compose/material/ripple/RippleHostMap;", "", "<init>", "()V", "indicationToHostMap", "", "Landroidx/compose/material/ripple/RippleHostKey;", "Landroidx/compose/material/ripple/RippleHostView;", "hostToIndicationMap", "set", "", "indicationInstance", "rippleHostView", "get", "remove", "material-ripple"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class RippleHostMap {
    private final Map<RippleHostView, RippleHostKey> hostToIndicationMap;
    private final Map<RippleHostKey, RippleHostView> indicationToHostMap;

    public RippleHostMap() {
        this.indicationToHostMap = new LinkedHashMap();
        this.hostToIndicationMap = new LinkedHashMap();
    }

    public final RippleHostKey get(RippleHostView r2) {
        return this.hostToIndicationMap.get(r2);
    }

    public final void remove(RippleHostKey r3) {
        RippleHostView r0 = this.indicationToHostMap.get(r3);
        if (r0 == null) goto L5;
        RippleHostKey r1 = this.hostToIndicationMap.remove(r0);
    L5:
        this.indicationToHostMap.remove(r3);
    }

    public final RippleHostView get(RippleHostKey r2) {
        return this.indicationToHostMap.get(r2);
    }

    public final void set(RippleHostKey r2, RippleHostView r3) {
        this.indicationToHostMap.put(r2, r3);
        this.hostToIndicationMap.put(r3, r2);
    }
}
