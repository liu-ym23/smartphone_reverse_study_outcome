package ev7;

import com.google.archivepatcher.shared.JreDeflateParameters;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.List;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;
import javax.annotation.Nonnull;

/* JADX INFO: loaded from: classes23.dex */
public final class k extends FilterOutputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OutputStream f474488a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Deflater f474489b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public DeflaterOutputStream f474490c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final byte[] f474491d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f474492e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f474493f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Iterator<g> f474494g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public g f474495h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Deflater f474496i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Deflater f474497j;

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public final void write(int r100) throws IOException {
        byte[] r101 = this.f474491d;
        r101[0] = (byte) r100;
        write(r101, 0, 1);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public final void write(@Nonnull byte[] r100) throws IOException {
        write(r100, 0, r100.length);
    }

    public k(List r100, OutputStream r101) {
        super(r101);
        this.f474489b = null;
        this.f474490c = null;
        this.f474491d = new byte[1];
        this.f474495h = null;
        this.f474488a = r101;
        this.f474492e = 32768;
        Iterator<g> r102 = r100.iterator();
        this.f474494g = r102;
        if (r102.hasNext() == false) goto L5;
        this.f474495h = r102.next();
        return;
    L5:
        this.f474495h = null;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public final void write(@Nonnull byte[] r110, int r111, int r210) throws IOException {
        boolean r100 = false;
        int r101 = 0;
    L3:
        if (r101 >= r210) goto L66;
        int r102 = r111 + r101;
        int r103 = r210 - r101;
        g r104 = this.f474495h;
        if (r104 != null) goto L7;
        long r105 = -1;
    L9:
        if (r105 != 0) goto L27;
        if (this.f474490c == null) goto L13;
        boolean r106 = true;
    L14:
        if (r106 == true) goto L27;
        JreDeflateParameters r107 = this.f474495h.f474480a.f495966b;
        if (r107.nowrap == false) goto L22;
        if (this.f474496i != null) goto L20;
        this.f474496i = new Deflater(r107.level, true);
    L20:
        Deflater r112 = this.f474496i;
    L25:
        this.f474489b = r112;
        r112.setLevel(r107.level);
        r112.setStrategy(r107.strategy);
        this.f474490c = new DeflaterOutputStream(this.f474488a, r112, this.f474492e);
        goto L27
    L22:
        if (this.f474497j != null) goto L24;
        this.f474497j = new Deflater(r107.level, r100);
    L24:
        r112 = this.f474497j;
        goto L25
    L13:
        r106 = false;
    L27:
        if (this.f474490c == null) goto L29;
        boolean r108 = true;
    L30:
        if (r108 == false) goto L37;
        long r109 = r103;
        g r113 = this.f474495h;
        if (r113 != null) goto L34;
        long r114 = -1;
    L35:
        r103 = (int) Math.min(r109, r114);
        OutputStream r115 = this.f474490c;
    L36:
        r101 = r101;
        int r116 = r103;
    L45:
        r115.write(r110, r102, r116);
        this.f474493f += (long) r116;
        if (this.f474490c == null) goto L48;
        boolean r117 = true;
    L49:
        if (r117 == false) goto L65;
        g r118 = this.f474495h;
        if (r118 != null) goto L53;
        long r119 = -1;
    L55:
        if (r119 != 0) goto L65;
        this.f474490c.finish();
        this.f474490c.flush();
        this.f474490c = null;
        this.f474489b.reset();
        JreDeflateParameters r120 = this.f474495h.f474480a.f495966b;
        if (this.f474494g.hasNext() == false) goto L59;
        this.f474495h = this.f474494g.next();
        goto L65
    L59:
        this.f474495h = null;
        Deflater r121 = this.f474496i;
        if (r121 == null) goto L62;
        r121.end();
        this.f474496i = null;
    L62:
        Deflater r122 = this.f474497j;
        if (r122 == null) goto L65;
        r122.end();
        this.f474497j = null;
        goto L65
    L53:
        r119 = (r118.f474480a.b() + this.f474495h.f474480a.a()) - this.f474493f;
    L65:
        r101 = r116 + r101;
        r100 = false;
        goto L3
    L48:
        r117 = false;
        goto L49
    L34:
        r114 = (r113.f474480a.b() + this.f474495h.f474480a.a()) - this.f474493f;
        goto L35
    L37:
        r115 = this.f474488a;
        g r123 = this.f474495h;
        if (r123 == null) goto L36;
        long r124 = r103;
        if (r123 != null) goto L43;
        long r125 = -1;
    L44:
        r116 = (int) Math.min(r124, r125);
        goto L45
    L43:
        r125 = r123.f474480a.b() - this.f474493f;
        goto L44
    L29:
        r108 = false;
        goto L30
    L7:
        r105 = r104.f474480a.b() - this.f474493f;
        goto L9
    }
}
