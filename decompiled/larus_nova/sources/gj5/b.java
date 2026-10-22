package gj5;

import com.ss.android.lark.security.compliance.api.model.filepolicy.CheckPriority;
import com.ss.android.lark.security.compliance.api.model.filepolicy.EntityOperate;
import com.ss.android.lark.security.compliance.api.model.filepolicy.EntityType;
import com.ss.android.lark.security.compliance.api.model.filepolicy.FileBizDomain;
import kotlin.Deprecated;
import yh5.k;

/* JADX INFO: loaded from: classes18.dex */
public interface b {
    void a(@EntityOperate String r100, FileBizDomain r101, int r102, String r103, Long r104, String r105, String r106, CheckPriority r107, a r108);

    void b(FileBizDomain r100, String r101, String r102, String r103, Integer r104, FileBizDomain r105);

    @Deprecated(message = "PermissionSDK")
    void c(@EntityOperate String r100, FileBizDomain r101, int r102, String r103);

    @Deprecated(message = "PermissionSDK.asyncValidate")
    void d(@EntityOperate String r100, FileBizDomain r101, int r102, String r103, Long r104, s55.c r105);

    c e(@EntityOperate String r100, FileBizDomain r101, int r102, String r103, String r104, String r105, Integer r106, boolean r107, FileBizDomain r108, String r110, @EntityType String r111);

    void f(@EntityOperate String r100, FileBizDomain r101, int r102, String r103, Long r104, String r105, String r106, CheckPriority r107, String r108, Long r110, Long r111, Long r112, k r113);

    @Deprecated(message = "PermissionSDK.validate")
    c g(@EntityOperate String r100, FileBizDomain r101, int r102, String r103);
}
