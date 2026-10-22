package com.bytedance.ee.bear.drive.biz.versions;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.parser.Feature;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.drive.biz.versions.model.DriveVersionHistoryRecord;
import d75.d;
import du5.b;
import io.reactivex.Flowable;
import java.io.Serializable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class VersionHistoryRepository {
    public final NetService.d<Result<DriveVersionHistoryRecord>> a;

    public static class Params implements Serializable {

        @JSONField(name = "file_token")
        public String fileToken;

        @JSONField(name = "is_asc")
        public boolean isAsc;

        @JSONField(name = "last_edit_time")
        public long lastEditTime;

        @JSONField(name = "only_tag")
        public boolean onlyTag;

        @JSONField(name = "page_size")
        public int pageSize;

        public Params() {
        }

        public String toString() {
            return "Params{fileToken='" + b.g(this.fileToken) + "', pageSize=" + this.pageSize + ", lastEditTime='" + this.lastEditTime + "', isAsc=" + this.isAsc + ", onlyTag=" + this.onlyTag + '}';
        }
    }

    public static class a implements NetService.c<Result<DriveVersionHistoryRecord>> {

        /* JADX INFO: renamed from: com.bytedance.ee.bear.drive.biz.versions.VersionHistoryRepository$a$a, reason: collision with other inner class name */
        public class C0159a extends TypeReference<Result<DriveVersionHistoryRecord>> {
            public C0159a() {
            }
        }

        public a() {
        }

        @Override // com.bytedance.ee.bear.contract.NetService.c
        public final Result<DriveVersionHistoryRecord> parse(String r3) throws NetService.ParseException {
            Result<DriveVersionHistoryRecord> r4 = (Result) JSON.parseObject(r3, new C0159a(), new Feature[0]);
            if (r4 == null) goto L5;
            return r4;
        L5:
            tt5.a.d("VersionHistoryRepository", "parse DriveVersionHistoryRecord error");
            throw new NetService.ParseException();
        }
    }

    public VersionHistoryRepository(NetService r2) {
        this.a = r2.Vc(new a());
    }

    public final Flowable<Result<DriveVersionHistoryRecord>> a(String r3, int r4, long r5) {
        tt5.a.h("VersionHistoryRepository", "start fetch history...");
        Params r0 = new Params();
        r0.fileToken = r3;
        r0.pageSize = r4;
        r0.lastEditTime = r5;
        NetService.f r6 = new NetService.f("/api/box/file/history/");
        r6.j = JSON.toJSONString(r0);
        r6.c = 1;
        return this.a.a(r6).onErrorResumeNext(new d(r0));
    }
}
