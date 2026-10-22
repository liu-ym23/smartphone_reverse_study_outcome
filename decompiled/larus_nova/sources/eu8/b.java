package eu8;

import android.content.Context;
import com.google.gson.JsonElement;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes26.dex */
public final class b extends a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList<File> f474098c;

    @Override // eu8.a
    public final String a() {
        StringBuilder r100 = new StringBuilder();
        ArrayList<File> r101 = this.f474098c;
        if (r101 == null) goto L12;
        Iterator<File> r102 = r101.iterator();
        boolean r103 = false;
    L6:
        if (r102.hasNext() == false) goto L14;
        File r104 = r102.next();
        if (r104.exists() == false) goto L6;
        if (r104.isFile() == false) goto L6;
        r103 = r104.delete();
        r100.append(r104);
    L14:
        return String.format("delete %s result %b", new Object[]{r100, Boolean.valueOf(r103)});
    L12:
        r103 = false;
        goto L14
    }

    public b(Context r100, JsonElement r101, ArrayList<File> r102) {
        super(r100, r101);
        this.f474098c = r102;
    }
}
