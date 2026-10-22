package com.bytedance.ee.bear.doc.follow.event;

import com.bytedance.ee.util.io.NonProguard;
import du5.b;

/* JADX INFO: loaded from: classes16.dex */
public class PresenterLocationChangedEvent implements ContentEvent {
    public Location follower;
    public Location presenter;

    public static class Location implements NonProguard {

        /* JADX INFO: renamed from: space, reason: collision with root package name */
        public String f217896space;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public double f217897x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public double f217898y;

        public Location() {
        }

        public String toString() {
            return "Location{x=" + this.f217897x + ", y=" + this.f217898y + ", space='" + b.g(this.f217896space) + "'}";
        }

        public String getSpace() {
            return this.f217896space;
        }

        public double getX() {
            return this.f217897x;
        }

        public double getY() {
            return this.f217898y;
        }

        public void setSpace(String r100) {
            this.f217896space = r100;
        }

        public void setX(double r100) {
            this.f217897x = r100;
        }

        public void setY(double r100) {
            this.f217898y = r100;
        }
    }

    public PresenterLocationChangedEvent() {
    }

    public String toString() {
        return "PresenterLocationChangedEvent{presenter=" + this.presenter.toString() + ", follower=" + this.follower.toString() + '}';
    }

    public Location getFollower() {
        return this.follower;
    }

    public Location getPresenter() {
        return this.presenter;
    }

    public void setFollower(Location r100) {
        this.follower = r100;
    }

    public void setPresenter(Location r100) {
        this.presenter = r100;
    }
}
