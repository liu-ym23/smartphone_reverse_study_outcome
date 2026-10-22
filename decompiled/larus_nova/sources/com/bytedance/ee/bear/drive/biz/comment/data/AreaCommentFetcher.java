package com.bytedance.ee.bear.drive.biz.comment.data;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.parser.Feature;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.scaleimageview.areacomment.AreaCoordinate;
import java.io.Serializable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes16.dex */
public final class AreaCommentFetcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final NetService.d<Result<ArrayList<AreaComment>>> f222736a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final NetService.d<Result> f222737b;

    public static class AddParam implements Serializable {

        @JSONField(name = "comment_id")
        private String commentId;
        private Extra extra;

        @JSONField(name = "file_token")
        private String fileToken;
        private String version;

        public static class Extra implements Serializable {

            @JSONField(name = "drive_area_coordinate")
            private AreaCoordinate areaCoordinate;

            private Extra() {
            }

            public AreaCoordinate getAreaCoordinate() {
                return this.areaCoordinate;
            }

            public /* synthetic */ Extra(a r100) {
                this();
            }

            public void setAreaCoordinate(AreaCoordinate r100) {
                this.areaCoordinate = r100;
            }
        }

        private AddParam() {
        }

        public String getCommentId() {
            return this.commentId;
        }

        public Extra getExtra() {
            return this.extra;
        }

        public String getFileToken() {
            return this.fileToken;
        }

        public String getVersion() {
            return this.version;
        }

        public /* synthetic */ AddParam(a r100) {
            this();
        }

        public void setCommentId(String r100) {
            this.commentId = r100;
        }

        public void setExtra(Extra r100) {
            this.extra = r100;
        }

        public void setFileToken(String r100) {
            this.fileToken = r100;
        }

        public void setVersion(String r100) {
            this.version = r100;
        }
    }

    public static class AreaComment implements Serializable {

        @JSONField(name = "drive_area_coordinate")
        private AreaCoordinate areaCoordinate;

        @JSONField(name = "comment_id")
        private String commentId;

        public AreaComment() {
        }

        public AreaCoordinate getAreaCoordinate() {
            return this.areaCoordinate;
        }

        public String getCommentId() {
            return this.commentId;
        }

        public void setAreaCoordinate(AreaCoordinate r100) {
            this.areaCoordinate = r100;
        }

        public void setCommentId(String r100) {
            this.commentId = r100;
        }
    }

    public static /* synthetic */ class a {
    }

    public static class b implements NetService.c<Result<ArrayList<AreaComment>>> {

        public class a extends TypeReference<Result<ArrayList<AreaComment>>> {
            public a() {
            }
        }

        public b() {
        }

        @Override // com.bytedance.ee.bear.contract.NetService.c
        public final Result<ArrayList<AreaComment>> parse(String r100) throws NetService.ParseException {
            tt5.a.b("AreaCommentFetcher", "get comment " + r100);
            return (Result) JSON.parseObject(r100, new a(), new Feature[0]);
        }
    }

    public AreaCommentFetcher(NetService r100) {
        this.f222736a = r100.Vc(new b());
        this.f222737b = r100.Rb(Result.class);
    }
}
