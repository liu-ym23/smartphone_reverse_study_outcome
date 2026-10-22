package com.bytedance.ee.bear.contract.offline;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001a\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u0006\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 32\u00020\u00012\u00020\u00022\u00020\u0003:\u00013B\t\b\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-J\u0018\u0010.\u001a\u00020+2\u0006\u0010/\u001a\u00020-2\u0006\u00100\u001a\u00020\u0013H\u0016J\b\u00101\u001a\u00020\u0013H\u0016J\b\u00102\u001a\u00020\u0000H\u0014R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000bR\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\t\"\u0004\b\u001a\u0010\u000bR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\t\"\u0004\b\u001d\u0010\u000bR\u001a\u0010\u001e\u001a\u00020\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001a\u0010$\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0015\"\u0004\b&\u0010\u0017R\u001c\u0010'\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\t\"\u0004\b)\u0010\u000b¨\u00064"}, d2 = {"Lcom/bytedance/ee/bear/contract/offline/DocWikiInfo;", "Lcom/bytedance/ee/util/io/NonProguard;", "Landroid/os/Parcelable;", "", "<init>", "()V", DocViewModel.EXTRA_SPACE_ID, "", "getSpace_id", "()Ljava/lang/String;", "setSpace_id", "(Ljava/lang/String;)V", "wiki_token", "getWiki_token", "setWiki_token", "obj_token", "getObj_token", "setObj_token", "obj_type", "", "getObj_type", "()I", "setObj_type", "(I)V", "title", "getTitle", "setTitle", "parent_wiki_token", "getParent_wiki_token", "setParent_wiki_token", "sort_id", "", "getSort_id", "()D", "setSort_id", "(D)V", "wiki_node_type", "getWiki_node_type", "setWiki_node_type", "url", "getUrl", "setUrl", "readFromParcel", "", "parcel", "Landroid/os/Parcel;", "writeToParcel", "dest", "flags", "describeContents", "clone", "CREATOR", "docs-document-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DocWikiInfo implements NonProguard, Parcelable, Cloneable {
    public static final a CREATOR = null;
    private static final String TAG = "DocWikiInfo";
    private String obj_token;
    private int obj_type;
    private String parent_wiki_token;
    private double sort_id;
    private String space_id;
    private String title;
    private String url;
    private int wiki_node_type;
    private String wiki_token;

    public static final class a implements Parcelable.Creator<DocWikiInfo> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final DocWikiInfo createFromParcel(Parcel r2) {
            Intrinsics.checkNotNullParameter(r2, "parcel");
            DocWikiInfo r0 = new DocWikiInfo();
            r0.readFromParcel(r2);
            return r0;
        }

        @Override // android.os.Parcelable.Creator
        public final DocWikiInfo[] newArray(int r1) {
            return new DocWikiInfo[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public DocWikiInfo() {
        this.obj_type = 2;
    }

    public DocWikiInfo clone() {
        Object r0 = super.clone();     // Catch: Throwable -> L4
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.bytedance.ee.bear.contract.offline.DocWikiInfo");     // Catch: Throwable -> L4
        return (DocWikiInfo) r0;
    L4:
        th = move-exception;
        tt5.a.d(TAG, "clone fail: " + th);
        return new DocWikiInfo();
    }

    public final String getObj_token() {
        return this.obj_token;
    }

    public final int getObj_type() {
        return this.obj_type;
    }

    public final String getParent_wiki_token() {
        return this.parent_wiki_token;
    }

    public final double getSort_id() {
        return this.sort_id;
    }

    public final String getSpace_id() {
        return this.space_id;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getUrl() {
        return this.url;
    }

    public final int getWiki_node_type() {
        return this.wiki_node_type;
    }

    public final String getWiki_token() {
        return this.wiki_token;
    }

    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m116clone() {
        return clone();
    }

    public final void readFromParcel(Parcel r3) {
        Intrinsics.checkNotNullParameter(r3, "parcel");
        this.space_id = r3.readString();
        this.wiki_token = r3.readString();
        this.obj_token = r3.readString();
        this.obj_type = r3.readInt();
        this.title = r3.readString();
        this.parent_wiki_token = r3.readString();
        this.sort_id = r3.readDouble();
        this.wiki_node_type = r3.readInt();
        this.url = r3.readString();
    }

    public final void setObj_token(String r1) {
        this.obj_token = r1;
    }

    public final void setObj_type(int r1) {
        this.obj_type = r1;
    }

    public final void setParent_wiki_token(String r1) {
        this.parent_wiki_token = r1;
    }

    public final void setSort_id(double r1) {
        this.sort_id = r1;
    }

    public final void setSpace_id(String r1) {
        this.space_id = r1;
    }

    public final void setTitle(String r1) {
        this.title = r1;
    }

    public final void setUrl(String r1) {
        this.url = r1;
    }

    public final void setWiki_node_type(int r1) {
        this.wiki_node_type = r1;
    }

    public final void setWiki_token(String r1) {
        this.wiki_token = r1;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "dest");
        r3.writeString(this.space_id);
        r3.writeString(this.wiki_token);
        r3.writeString(this.obj_token);
        r3.writeInt(this.obj_type);
        r3.writeString(this.title);
        r3.writeString(this.parent_wiki_token);
        r3.writeDouble(this.sort_id);
        r3.writeInt(this.wiki_node_type);
        r3.writeString(this.url);
    }
}
