package xr7;

import com.cronutils.model.field.CronField;
import com.cronutils.model.time.generator.NoSuchValueException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes22.dex */
public abstract class l extends i {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f564874b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f564875c;

    @Override // xr7.i
    public final List<Integer> b(int r100, int r101) {
        ArrayList r102 = new ArrayList();
        int r103 = c(r100);     // Catch: NoSuchValueException -> L8
    L4:
        if (r103 >= r101) goto L7;
        r102.add(Integer.valueOf(r103));     // Catch: NoSuchValueException -> L8
        r103 = c(r103);     // Catch: NoSuchValueException -> L8
    L7:
        return r102;
    }

    public l(CronField r100, int r101, int r102) {
        super(r100);
        this.f564874b = r101;
        this.f564875c = r102;
    }
}
