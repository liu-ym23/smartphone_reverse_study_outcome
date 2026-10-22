package com.bytedance.ee.bear.document.authors;

import com.bytedance.ee.util.io.NonProguard;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0018\b\u0002\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005HÆ\u0003J#\u0010\u000b\u001a\u00020\u00002\u0018\b\u0002\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R!\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/bytedance/ee/bear/document/authors/AuthorsBean;", "Lcom/bytedance/ee/util/io/NonProguard;", "authors", "Ljava/util/ArrayList;", "Lcom/bytedance/ee/bear/document/authors/Author;", "Lkotlin/collections/ArrayList;", "<init>", "(Ljava/util/ArrayList;)V", "getAuthors", "()Ljava/util/ArrayList;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AuthorsBean implements NonProguard {
    private final ArrayList<Author> authors;

    /* JADX WARN: Multi-variable type inference failed */
    public AuthorsBean() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AuthorsBean copy$default(AuthorsBean r100, ArrayList r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.authors;
    L6:
        return r100.copy(r101);
    }

    public final ArrayList<Author> component1() {
        return this.authors;
    }

    public final AuthorsBean copy(ArrayList<Author> r100) {
        Intrinsics.checkNotNullParameter(r100, "authors");
        return new AuthorsBean(r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof AuthorsBean) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.authors, ((AuthorsBean) r100).authors) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        return this.authors.hashCode();
    }

    public String toString() {
        return "AuthorsBean(authors=" + this.authors + ')';
    }

    public final ArrayList<Author> getAuthors() {
        return this.authors;
    }

    public AuthorsBean(ArrayList<Author> r100) {
        Intrinsics.checkNotNullParameter(r100, "authors");
        this.authors = r100;
    }

    public /* synthetic */ AuthorsBean(ArrayList r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = new ArrayList();
    L5:
        this(r100);
    }
}
