package yq5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b implements Cloneable {
    public String a;
    public String b;
    public String c;
    public int d;
    public String e;
    public String f;
    public double g;
    public int h;
    public String i;
    public String j;
    public boolean k;
    public String l;
    public String m;
    public boolean n;
    public boolean o;
    public boolean p;
    public boolean q;
    public int r;
    public String s;
    public String t;
    public String u;

    public b() {
    }

    public final Object clone() throws CloneNotSupportedException {
        return (b) super.clone();
    L4:
        e = move-exception;
        tt5.a.d("DBTreeNode", "clone DBTreeNode fail. " + e);
        return new b();
    }
}
