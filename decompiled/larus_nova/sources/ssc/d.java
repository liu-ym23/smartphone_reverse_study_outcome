package ssc;

import android.text.TextUtils;
import com.bytedance.mt.protector.impl.PatternProtector;
import io.noties.markwon.ext.tasklist.TaskListItem;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.commonmark.node.ListItem;
import org.commonmark.node.Paragraph;
import org.commonmark.node.Text;

/* JADX INFO: loaded from: classes5.dex */
public final class d implements vvc.f {

    /* JADX INFO: loaded from: classes41.dex */
    public static class a extends uvc.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Pattern f543521a = null;

        static {
            f543521a = PatternProtector.compile("^\\[([xX\\s])]\\s+(.*)");
        }

        public a() {
        }

        @Override // uvc.a, uvc.c
        public final void w(ListItem r100) {
            uvc.b r101 = r100.f551901b;
            if ((r101 instanceof Paragraph) == false) goto L31;
            uvc.b r102 = r101.f551901b;
            if ((r102 instanceof Text) == false) goto L31;
            Matcher r103 = f543521a.matcher(((Text) r102).f525783h);
            if (r103.matches() == false) goto L31;
            boolean r104 = true;
            String r105 = r103.group(1);
            if ("x".equals(r105) == false) goto L11;
        L14:
            TaskListItem r106 = new TaskListItem(r104);
            Paragraph r107 = new Paragraph();
            r106.g();
            uvc.b r108 = r100.f551903d;
            r106.f551903d = r108;
            if (r108 == null) goto L17;
            r108.f551904e = r106;
        L17:
            r106.f551904e = r100;
            r100.f551903d = r106;
            uvc.b r109 = r100.f551900a;
            r106.f551900a = r109;
            if (r106.f551903d != null) goto L20;
            r109.f551901b = r106;
        L20:
            String r110 = r103.group(2);
            if (TextUtils.isEmpty(r110) == true) goto L23;
            r107.b(new Text(r110));
        L23:
            uvc.b r111 = r102.f551904e;
        L24:
            if (r111 == null) goto L26;
            uvc.b r112 = r111.f551904e;
            r107.b(r111);
            r111 = r112;
            goto L24
        L26:
            r106.b(r107);
            uvc.b r113 = r101.f551904e;
        L27:
            if (r113 == null) goto L29;
            uvc.b r114 = r113.f551904e;
            r106.b(r113);
            r113 = r114;
            goto L27
        L29:
            r100.g();
            c(r106);
            return;
        L11:
            if ("X".equals(r105) == true) goto L14;
            r104 = false;
        L31:
            c(r100);
        }
    }

    public d() {
    }

    @Override // vvc.f
    public final uvc.b a(uvc.b r100) {
        r100.a(new a());
        return r100;
    }
}
