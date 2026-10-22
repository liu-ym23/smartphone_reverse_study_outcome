package com.suite.lark.platform.component.storage.clean.request;

import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.suite.lark.platform.component.storage.clean.CleanRequest;
import com.suite.lark.platform.component.storage.clean.PersistentRequest;
import com.suite.lark.platform.component.storage.clean.PersistentResource;
import com.suite.lark.platform.component.storage.clean.f;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u0000 \u001b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001b\u001cBG\b\u0002\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004\u0012\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0004¢\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0012J\u000e\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00120\u0004H\u0016J\u000e\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0012J\u000e\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00120\u0004H\u0016R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u0016\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011j\n\u0012\u0004\u0012\u00020\u0012\u0018\u0001`\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0014\u001a\u0016\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011j\n\u0012\u0004\u0012\u00020\u0012\u0018\u0001`\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/suite/lark/platform/component/storage/clean/request/RemoteClearRequest;", "Lcom/suite/lark/platform/component/storage/clean/PersistentRequest;", "Lcom/suite/lark/platform/component/storage/clean/PersistentResource;", "userList", "", "Lcom/suite/lark/platform/component/storage/clean/request/UserInfo;", "uniqueName", "", DBDefinition.RETRY_COUNT, "", "resources", "whitelistResources", "<init>", "(Ljava/util/List;Ljava/lang/String;ILjava/util/List;Ljava/util/List;)V", "getUserList", "()Ljava/util/List;", "tempResources", "Ljava/util/ArrayList;", "Lcom/suite/lark/platform/component/storage/clean/CleanableResource;", "Lkotlin/collections/ArrayList;", "tempWhitelistResource", "addResource", "", "res", "getResources", "addWhitelistResource", "getWhitelistResources", "Companion", "Builder", "lark-storage_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RemoteClearRequest extends PersistentRequest<PersistentResource> {
    public static final b Companion = null;
    private static final String Name = null;
    private transient ArrayList<f> tempResources;
    private transient ArrayList<f> tempWhitelistResource;
    private final List<Object> userList;

    public static final class a extends CleanRequest.a<PersistentResource, RemoteClearRequest, a> {
    }

    public static final class b {
        public b() {
        }
    }

    public /* synthetic */ RemoteClearRequest(List r100, String r101, int r102, List r103, List r104, DefaultConstructorMarker r105) {
        this(r100, r101, r102, r103, r104);
    }

    static {
        Companion = new b();
        Name = "remote_clear_all_user";
    }

    public static final String getName() {
        Companion.getClass();
        return access$getName$cp();
    }

    @Override // com.suite.lark.platform.component.storage.clean.CleanRequest
    public List<f> getResources() {
        ArrayList r100 = new ArrayList();
        r100.addAll(super.getResources());
        ArrayList<f> r101 = this.tempResources;
        if (r101 == null) goto L5;
        r100.addAll(r101);
    L5:
        return r100;
    }

    @Override // com.suite.lark.platform.component.storage.clean.CleanRequest
    public List<f> getWhitelistResources() {
        ArrayList r100 = new ArrayList();
        List<f> r101 = super.getWhitelistResources();
        if (r101 == null) goto L5;
        r100.addAll(r101);
    L5:
        ArrayList<f> r102 = this.tempWhitelistResource;
        if (r102 == null) goto L8;
        r100.addAll(r102);
    L8:
        return r100;
    }

    public static final /* synthetic */ String access$getName$cp() {
        return Name;
    }

    public final List<Object> getUserList() {
        return this.userList;
    }

    public final void addResource(f r100) {
        Intrinsics.checkNotNullParameter(r100, "res");
        if (this.tempResources != null) goto L5;
        this.tempResources = new ArrayList();
    L5:
        ArrayList<f> r101 = this.tempResources;
        if (r101 == null) goto L9;
        r101.add(r100);
        return;
    }

    public final void addWhitelistResource(f r100) {
        Intrinsics.checkNotNullParameter(r100, "res");
        if (this.tempWhitelistResource != null) goto L5;
        this.tempWhitelistResource = new ArrayList();
    L5:
        ArrayList<f> r101 = this.tempWhitelistResource;
        if (r101 == null) goto L9;
        r101.add(r100);
        return;
    }

    private RemoteClearRequest(List<Object> r100, String r101, int r102, List<? extends PersistentResource> r103, List<? extends PersistentResource> r104) {
        super(r101, r102, r103, r104);
        this.userList = r100;
    }

    public /* synthetic */ RemoteClearRequest(List r100, String r101, int r102, List r110, List r111, int r112, DefaultConstructorMarker r113) {
        if ((r112 & 16) == 0) goto L5;
        r111 = null;
    L5:
        this(r100, r101, r102, r110, r111);
    }
}
