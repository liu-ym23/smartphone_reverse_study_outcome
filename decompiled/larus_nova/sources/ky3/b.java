package ky3;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;

/* JADX INFO: loaded from: classes14.dex */
public final class b extends o14.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f506626d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f506627e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f506628f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f506629g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f506630h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f506631i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f506632j;

    public b(o14.a r100) {
        this.f506628f = "";
        this.f506630h = true;
        this.f521700a = 11;
        String r101 = r100.cid;
        this.f506626d = r101;
        this.cid = r101 + "-reply-button";
        List<o14.a> r102 = r100.replyComments;
        if (r102 == null) goto L14;
        int r103 = r102.size();
        StringBuilder r104 = new StringBuilder();
        int r105 = 0;
    L5:
        if (r105 >= r103) goto L9;
        if (r105 <= 0) goto L8;
        r104.append(",");
    L8:
        r104.append(((o14.a) ListProtector.get(r100.replyComments, r105)).cid);
        r105 = r105 + 1;
        goto L5
    L9:
        this.f506628f = r104.toString();
        Integer r106 = r100.n();
        if (r106 == null) goto L12;
        this.f506632j = r106.intValue();
    L13:
        this.f506629g = Math.max(0, r103 - 1);
        this.f506631i = r103;
        goto L14
    L12:
        this.f506632j = r103;
    L14:
        this.replyCommentTotal = r100.replyCommentTotal;
    }
}
