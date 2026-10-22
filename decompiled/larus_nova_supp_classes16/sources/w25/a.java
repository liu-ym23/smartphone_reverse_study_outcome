package w25;

import android.text.TextUtils;
import com.bytedance.ee.bear.document.comment.bean.Card;
import com.bytedance.ee.bear.document.comment.bean.ShowCardsJsData;
import com.bytedance.ee.bear.document.offline.file.upload.FileUploadModel;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentBean;
import db5.d;
import db5.j;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a<T> implements Consumer {
    public final /* synthetic */ ShowCardsJsData a;

    public a(ShowCardsJsData r1) {
        this.a = r1;
    }

    public final void accept(Object r11) {
        Boolean r12 = (Boolean) r11;
        List<Card> r13 = this.a.getCards();
        ArrayList r0 = new ArrayList();
        Iterator<T> r14 = r13.iterator();
    L4:
        if (r14.hasNext() == false) goto L6;
        CollectionsKt.addAll(r0, ((Card) r14.next()).getCommentList());
        goto L4
    L6:
        ArrayList r16 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
        Iterator r1 = r0.iterator();
    L8:
        if (r1.hasNext() == false) goto L10;
        r16.add(((CommentBean.CommentDetail) r1.next()).getContent());
        goto L8
    L10:
        Boolean r2 = c.a;
        ArrayList r3 = new ArrayList();
        Iterator r17 = r16.iterator();
    L12:
        if (r17.hasNext() == false) goto L43;
        String r4 = (String) r17.next();
        int r5 = 0;
        if (StringsKt.contains$default(r4, "http", false, 2, null) == false) goto L12;
        db5.a r6 = new d().c(r4);
        j[] r7 = r6.c;
        ArrayList r8 = new ArrayList(r7.length);
        int r9 = r7.length;
        int r10 = 0;
    L16:
        boolean r18 = true;
        if (r10 >= r9) goto L29;
        j r19 = r7[r10];
        String r20 = r19.c;
        if (r20 != null) goto L21;
    L24:
        if (r18 == true) goto L28;
        if (r3.contains(r19.c) == true) goto L28;
        r3.add(r19.c);
    L28:
        r8.add(Unit.INSTANCE);
        r10 = r10 + 1;
        goto L16
    L21:
        if (r20.length() == 0) goto L24;
        r18 = false;
        goto L24
    L29:
        bo4.a[] r21 = r6.b;
        Intrinsics.checkNotNull(r21);
        if (r21.length != 0) goto L32;
        boolean r22 = true;
    L34:
        if ((!r22) == false) goto L12;
        int r23 = r21.length;
    L36:
        if (r5 >= r23) goto L12;
        bo4.a r24 = r21[r5];
        if (TextUtils.isEmpty(r24.f) == true) goto L42;
        if (r3.contains(r24.f) == true) goto L42;
        r3.add(r24.f);
    L42:
        r5 = r5 + 1;
        goto L36
    L32:
        r22 = false;
        goto L34
    L43:
        c.d(r3, FileUploadModel.FROM_COMMENT);
    }
}
