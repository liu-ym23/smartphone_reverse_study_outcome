package hv5;

import com.bytedance.express.command.IdentifierCommand;

/* JADX INFO: loaded from: classes3.dex */
public final class f extends a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f487315c;

    @Override // hv5.a
    public final IdentifierCommand b() {
        return new IdentifierCommand(this.f487315c);
    }

    public final String getIdentifier() {
        return this.f487315c;
    }

    public f(String r100, String r101) {
        super(r101);
        this.f487315c = r100;
    }
}
